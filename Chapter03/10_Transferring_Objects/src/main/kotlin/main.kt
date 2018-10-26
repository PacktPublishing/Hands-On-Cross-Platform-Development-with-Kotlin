import konan.worker.TransferMode
import konan.worker.startWorker

data class Data(val value: Double)

fun main(args: Array<String>) {

    val worker = startWorker()
    val mode = TransferMode.CHECKED

    val data = Data(1000.0)

    try {
        worker.schedule(mode, { data }) { it ->
            println("Item: ${it.value}")
        }.result()
    } catch (e: IllegalStateException){
        println(e)
    }

    val processScheduledJobs = true
    worker.requestTermination(processScheduledJobs)
}

