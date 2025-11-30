package fr.anthony.abkweb

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import abkweb.composeapp.generated.resources.Res
import abkweb.composeapp.generated.resources.logoalphaupscaled
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.darkColorScheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun App() {

    var isContentVisible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(100)
        isContentVisible = true
    }

    // Définition des couleurs extraites de votre carte de visite
    val deepBlueBackground = Color(0xFF223346) // Le bleu nuit du fond
    val textWhite = Color(0xFFE0E1DD)          // Un blanc cassé doux pour la lecture
    val cyanAccent = Color(0xFF4CC9F0)         // Le cyan du logo (pour les titres)
    val orangeAccent = Color(0xFFFFAB00)       // Le jaune orangé pour l'email

    // On applique un thème sombre personnalisé
    MaterialTheme(
        colorScheme = darkColorScheme(
            background = deepBlueBackground,
            surface = deepBlueBackground,
            onBackground = textWhite,
            onSurface = textWhite,
            primary = cyanAccent,
            secondary = orangeAccent
        )
    ) {
        Column {
            Text(
                text = "Site en cours de développement...",
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.secondary.copy(alpha = 0.5f))
                    .padding(vertical = 8.dp)
                    .height(IntrinsicSize.Min)
            )

            AnimatedVisibility(
                visible = isContentVisible,
                enter = fadeIn(animationSpec = tween(3000)) + slideInVertically(
                    animationSpec = tween(3000),
                    initialOffsetY = { it / 2 }
                ),
                modifier = Modifier.weight(1f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    Spacer(modifier = Modifier.height(48.dp))

                    Image(
                        painterResource(Res.drawable.logoalphaupscaled),
                        contentDescription = "AB-K Native Logo",
                        modifier = Modifier
                            .widthIn(max = 1000.dp)
                            .fillMaxWidth(0.9f)
                    )
                    SelectionContainer {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        ) {
                            Spacer(modifier = Modifier.height(48.dp))

                            Text(
                                text = "Développement d'Applications Métier sur Mesure.",
                                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.primary,
                                textAlign = TextAlign.Center,
                            )
                            Spacer(modifier = Modifier.height(48.dp))

                            Text(
                                text = "AB-K Native. Lancement officiel Printemps 2026.",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Spacer(modifier = Modifier.height(16.dp))

                            Text(
                                text = "Vous avez déjà un projet, ou vous aimeriez échanger sur vos idées ? Contactez-moi dès aujourd'hui :",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                // Adresse e-mail professionnelle (contact@abknative.fr)
                                text = "contact@abknative.fr",
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                color = MaterialTheme.colorScheme.secondary
                            )
                        }
                    }
                }
            }
        }
    }
}