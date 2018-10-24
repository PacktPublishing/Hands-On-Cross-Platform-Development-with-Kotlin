import konan.worker.freeze

fun main(args: Array<String>) {
    var number = 5
    number.freeze()
    number = 10
    print(number)
}
