import kotlinx.cinterop.*

fun main(args: Array<String>) {

    val placement = object : NativePlacement {

        // Alloc implementation:
        override fun alloc(size: Long, align: Int): NativePointed {

            // We will allocate some memory for illustration purposes:
            val ptr = alloc<IntVar>()

            // Returns NativePointed (abstract class) implementation:
            return object : NativePointed(ptr.rawPtr) { // Accepts raw pointer in the constructor

                // NativePointed implementation
            }
        }
    }
}
