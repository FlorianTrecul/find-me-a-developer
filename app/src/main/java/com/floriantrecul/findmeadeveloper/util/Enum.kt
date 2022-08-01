package com.floriantrecul.findmeadeveloper.util

import com.floriantrecul.findmeadeveloper.R

enum class ExceptionError(val title: Int, val message: Int) {
    HTTP_EXCEPTION(
        title = R.string.error_message_title_unknown_user,
        message = R.string.error_message_info_unknown_user
    ),
    UNKNOWN_HOST_EXCEPTION(
        title = R.string.error_message_title_no_network,
        message = R.string.error_message_info_no_network
    ),
    ERROR_EXCEPTION(
        title = R.string.error_message_title_unknown,
        message = R.string.error_message_info_unknown
    )
}