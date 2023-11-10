package pt.edequinox.aula1_sketches

enum class Screens (val display:String) {
    MENU ("Menu"),
    SOLID("Solid"),
    GALLERY("Gallery"),
    CAMERA("Camera"),
    LIST("List"),
    DRAWING("Drawing");

    val route:String
        get() = this.toString()
}