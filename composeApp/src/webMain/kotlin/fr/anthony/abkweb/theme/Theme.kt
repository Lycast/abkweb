package fr.anthony.abkweb.theme

object AppColors {

    // FONDS PRINCIPAUX : Blanc / Noir OLED
    val bgMain = arrayOf("bg-white", "dark:bg-black")

    // FONDS SECONDAIRES : Gris très clair / Gris très foncé pur (Fini le bleu nuit !)
    val bgSection = arrayOf("bg-surfaceLight", "dark:bg-surfaceDark")

    // TEXTES
    val textPrimary = arrayOf("text-slate-900", "dark:text-slate-300")
    val textSecondary = arrayOf("text-slate-600", "dark:text-slate-400")

    // MARQUE
    val primary = "text-brandPrimary"
    val secondary = "text-brandSecondary"
    val accent = "text-brandAccent"
}

object AppTypography {
    val h1 = arrayOf("text-5xl", "md:text-7xl", "font-heading", "font-bold", "leading-tight")
    val body = arrayOf("text-lg", "md:text-xl", "leading-relaxed")
}