import kotlinx.cinterop.*

fun main(args: Array<String>) {

    memScoped {
        var number = 0
        val length = 1024
        val data = allocArray<IntVar>(length)

        for (x in 0..length) {
            data[x] = number++
        }

        for (x in 0..length) {
            println("Value: ${data[x]}")
        }
    }
}
