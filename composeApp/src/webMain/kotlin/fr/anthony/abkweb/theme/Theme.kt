package fr.anthony.abkweb.theme

object AppColors {
    // --- FONDS ---
    val bgMain = arrayOf("bg-white", "dark:bg-black")
    val bgAlt = arrayOf("bg-slate-50", "dark:bg-zinc-950") // Fusion de bgSection et bgBanner
    val bgCard = arrayOf("bg-surfaceLight", "dark:bg-surfaceDark")

    // --- BORDURES ---
    val border = arrayOf("border", "border-slate-200", "dark:border-slate-800")

    // --- TEXTES ---
    val textPrimary = arrayOf("text-slate-900", "dark:text-slate-300")
    val textSecondary = arrayOf("text-slate-600", "dark:text-slate-400")

    // --- MARQUE (Variables brutes) ---
    const val primary = "brandPrimary"     // Juste le nom pour composer plus facilement
    const val secondary = "brandSecondary"
    const val accent = "brandAccent"

    // --- ÉTATS INTERACTIFS ---
    val hoverBrightness = "hover:brightness-110"
    val hoverBrand = arrayOf("hover:border-brandPrimary", "hover:text-brandPrimary")

    val themeTransition = arrayOf(
        "transition-colors",
        "duration-1000",
        "ease-in-out"
    )

    val shadow = "shadow-md"
}

object AppTypography {
    val h1 = arrayOf("text-4xl", "md:text-6xl", "font-bold", "leading-tight", "tracking-tight")
    val h2 = arrayOf("text-2xl", "md:text-4xl", "font-semibold", "leading-snug")
    val h3 = arrayOf("text-xl", "md:text-2xl", "font-medium", "leading-snug")

    val body = arrayOf("text-base", "md:text-lg", "leading-relaxed")
    val bodySmall = arrayOf("text-sm", "md:text-base", "leading-normal")
    val caption = arrayOf("text-xs", "uppercase", "tracking-widest", "font-semibold")
}

object AppSpacing {
    // --- LAYOUT (Grands espacements) ---
    val section = arrayOf("py-12", "md:py-24")       // Fusion de sectionY et blockPadding
    val sectionTight = arrayOf("py-6", "md:py-12")   // Unifié

    // --- COMPOSANTS (Espacements internes) ---
    val card = "p-8"
    val cardGap = "gap-4"
    val blockGap = arrayOf("gap-10", "md:gap-20")    // Espace entre image et texte
    val stack = "gap-6"                              // Espace entre titres/textes/boutons (textStack)

    // --- ÉLÉMENTS (Marges et boutons) ---
    val marginL = "mb-10"
    val marginM = "mb-6"
    val btnPadding = arrayOf("px-6", "py-3")
}

object AppShapes {
    val card = "rounded-2xl"
    val button = "rounded-lg"
}