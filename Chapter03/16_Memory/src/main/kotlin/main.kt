import kotlinx.cinterop.*

fun main(args: Array<String>) {
    // Allocate memory:
    val allocated = nativeHeap.alloc<IntVar>()

    // Set the value:
    allocated.value = 100
    println("Value is: ${allocated.value}")

    // De allocate memory:
    nativeHeap.free(allocated)
}
