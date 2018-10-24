import konan.worker.InvalidMutabilityException

enum class Dummies {
    A, B, C;

    var value = 0
}

fun main(args: Array<String>) {
    try {
        Dummies.A.value = 100
    } catch (e: InvalidMutabilityException){
        print(e)
    }
}
