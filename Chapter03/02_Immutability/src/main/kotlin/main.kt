import konan.worker.InvalidMutabilityException
import konan.worker.freeze

data class Student(
        var firstName: String,
        var lastName: String,
        var email: String
)

fun main(args: Array<String>) {
    val student = Student(
            "John",
            "Smith",
            "john@smith.com"
    )

    student.firstName = "New name"
    student.lastName = "New last name"
    student.email = "john2@example.com"

    student.freeze()

    try {
        student.firstName = "New name 2"
        student.lastName = "New last name 2"
        student.email = "john3@example.com"
    } catch (e: InvalidMutabilityException) {
        print(e)
    }
}
