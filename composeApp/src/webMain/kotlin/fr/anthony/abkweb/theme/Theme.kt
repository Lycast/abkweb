package fr.anthony.abkweb.theme

object AppColors {
    // On définit ici les paires Clair/Sombre pour éviter les oublis
    val bgMain = arrayOf("bg-white", "dark:bg-slate-900")
    val bgSection = arrayOf("bg-slate-50", "dark:bg-slate-800")

    val textPrimary = arrayOf("text-slate-900", "dark:text-white")
    val textSecondary = arrayOf("text-slate-600", "dark:text-slate-400")

    val cobalt = "text-cobalt" // Notre couleur de marque
    val emerald = "text-emerald"
}

object AppTypography {
    val h1 = arrayOf("text-5xl", "md:text-7xl", "font-heading", "font-bold", "leading-tight")
    val body = arrayOf("text-lg", "md:text-xl", "leading-relaxed")
}