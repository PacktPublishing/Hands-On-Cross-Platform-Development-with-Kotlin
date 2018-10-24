import konan.worker.InvalidMutabilityException

object X {
    var y = 5
}

fun main(args: Array<String>) {
    try {
        X.y = 10
        print(X.y)
    } catch (e: InvalidMutabilityException) {
        print(e)
    }
}
