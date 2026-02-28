package fr.anthony.abkweb.theme

object AppColors {
    // FONDS : On garde un blanc cassé et un bleu-nuit profond pour le premium
    val bgMain = arrayOf("bg-white", "dark:bg-black")
    val bgSection = arrayOf("bg-slate-50", "dark:bg-slate-900")

    // TEXTES
    val textPrimary = arrayOf("text-slate-900", "dark:text-white")
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