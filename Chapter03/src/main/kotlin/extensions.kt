import kotlinx.cinterop.*
import platform.android.*
import platform.posix.*
import platform.gles3.*
import platform.linux.*

const val tag = "Hands_On_Book"

fun info(msg: String) {
    /**
     *  int prio,
     *  const char *tag,
     *  const char *text
     */
    __android_log_write(ANDROID_LOG_INFO, tag, msg)
}

fun error(msg: String) {
    /**
     *  int prio,
     *  const char *tag,
     *  const char *text
     */
    __android_log_write(ANDROID_LOG_ERROR, tag, msg)
}