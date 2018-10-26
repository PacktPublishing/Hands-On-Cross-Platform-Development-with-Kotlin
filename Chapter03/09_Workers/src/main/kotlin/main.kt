import konan.worker.Future
import konan.worker.TransferMode
import konan.worker.startWorker
import platform.posix.pow

data class Data(val value: Double)

fun main(args: Array<String>) {

    val worker = startWorker()
    val mode = TransferMode.CHECKED

    for (x in 0..10) {
        val future = worker.schedule(mode, { Data(x.toDouble()) }) { it ->
            pow(it.value, 2.0)
        }

        printState(future)
        future.consume {
            printState(future)
            println("- - - - - - - - - -")
        }
    }

    val processScheduledJobs = true
    worker.requestTermination(processScheduledJobs)
}

fun printState(future: Future<Double>) {
    val futureId = future.id
    val futureState = future.state
    println("Future: $futureId -> $futureState")
}
