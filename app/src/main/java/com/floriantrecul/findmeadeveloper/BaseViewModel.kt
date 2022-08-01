package com.floriantrecul.findmeadeveloper

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

interface ViewAction

interface ViewState

interface ViewSideEffect

abstract class BaseViewModel<UiAction: ViewAction, UiState: ViewState, UiEffect: ViewSideEffect> : ViewModel() {

    abstract fun setInitialState(): UiState
    abstract fun handleActions(action: UiAction)

    private val initialState: UiState by lazy { setInitialState() }

    private val _viewState: MutableState<UiState> = mutableStateOf(initialState)
    val viewState: State<UiState> = _viewState

    private val _action: MutableSharedFlow<UiAction> = MutableSharedFlow()

    private val _effect: Channel<UiEffect> = Channel()
    val effect = _effect.receiveAsFlow()

    init {
        subscribeToEvents()
    }

    private fun subscribeToEvents() {
        viewModelScope.launch {
            _action.collect {
                handleActions(it)
            }
        }
    }

    fun setAction(action: UiAction) {
        viewModelScope.launch { _action.emit(action) }
    }

    protected fun setState(reducer: UiState.() -> UiState) {
        val newState = viewState.value.reducer()
        _viewState.value = newState
    }

    protected fun setEffect(builder: () -> UiEffect) {
        val effectValue = builder()
        viewModelScope.launch { _effect.send(effectValue) }
    }

}