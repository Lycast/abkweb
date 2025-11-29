package fr.anthony.abkweb

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform