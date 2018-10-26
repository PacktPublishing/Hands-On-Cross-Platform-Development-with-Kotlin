import konan.worker.TransferMode
import konan.worker.startWorker
import platform.posix.pow

data class Data(val value: Double)

fun main(args: Array<String>) {

    val worker = startWorker()
    val mode = TransferMode.CHECKED

    for (x in 0..10) {
        val future = worker.schedule(mode, { Data(x.toDouble()) }) { it ->
            println("Value: ${it.value}")
            pow(it.value, 2.0)
        }

        future.consume { it ->
            println("Power: $it\n- - - - - - - - -")
        }
    }

    val processScheduledJobs = true
    worker.requestTermination(processScheduledJobs)
}
