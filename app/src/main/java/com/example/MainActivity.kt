package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.ui.theme.*

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      val systemTheme = isSystemInDarkTheme()
      var isDarkTheme by remember { mutableStateOf(systemTheme) }

      MyApplicationTheme(darkTheme = isDarkTheme) {
        PortfolioSleekApp(
            isDarkTheme = isDarkTheme,
            onThemeToggle = { isDarkTheme = !isDarkTheme },
            modifier = Modifier.fillMaxSize()
        )
      }
    }
  }
}

@Composable
fun PortfolioSleekApp(
    isDarkTheme: Boolean,
    onThemeToggle: () -> Unit,
    modifier: Modifier = Modifier
) {
  var selectedTab by remember { mutableStateOf("Home") }

  Scaffold(
    modifier = modifier,
    containerColor = MaterialTheme.colorScheme.background,
    bottomBar = { 
        BottomNavigationBar(
            selectedTab = selectedTab,
            onTabSelected = { selectedTab = it }
        ) 
    }
  ) { innerPadding ->
    LazyColumn(
      modifier = Modifier.padding(innerPadding).fillMaxSize(),
      contentPadding = PaddingValues(top = 24.dp, bottom = 24.dp)
    ) {
      item { HeaderSection(isDarkTheme = isDarkTheme, onThemeToggle = onThemeToggle) }
      
      when (selectedTab) {
        "Home" -> {
          item { GreetingSection() }
          item { ContentSection() }
        }
        "Projects" -> {
          item { ProjectsSection() }
        }
        "About" -> {
          item { AboutSection() }
        }
        "Contact" -> {
          item { ContactSection() }
        }
      }
    }
  }
}

@Composable
fun HeaderSection(isDarkTheme: Boolean, onThemeToggle: () -> Unit) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 24.dp, vertical = 12.dp),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Box(
      modifier = Modifier
        .size(48.dp)
        .clip(CircleShape)
        .background(MaterialTheme.colorScheme.primaryContainer),
      contentAlignment = Alignment.Center
    ) {
      Text(
        text = "JK",
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.onPrimaryContainer,
        fontWeight = FontWeight.Bold
      )
    }
    IconButton(
      onClick = onThemeToggle,
      modifier = Modifier
        .size(48.dp)
        .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f), CircleShape)
    ) {
      Icon(
        imageVector = if (isDarkTheme) Icons.Outlined.LightMode else Icons.Outlined.DarkMode,
        contentDescription = "Toggle Theme",
        tint = MaterialTheme.colorScheme.onSurfaceVariant
      )
    }
  }
}

@Composable
fun GreetingSection() {
  Column(modifier = Modifier.padding(horizontal = 24.dp, vertical = 24.dp)) {
    Text(
      text = "Hello, I'm ",
      style = MaterialTheme.typography.displayMedium,
      color = MaterialTheme.colorScheme.onBackground
    )
    Text(
      text = "Jaakko",
      style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.SemiBold),
      color = MaterialTheme.colorScheme.primary
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
      text = "Full Stack Developer & UI Designer",
      style = MaterialTheme.typography.titleMedium,
      color = MaterialTheme.colorScheme.onSurfaceVariant
    )
  }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ContentSection() {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(horizontal = 16.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp)
  ) {
    // Featured Project Card
    Card(
      shape = RoundedCornerShape(28.dp),
      colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
      modifier = Modifier
        .fillMaxWidth()
        .clickable(
            onClick = { },
            onClickLabel = "View featured project Zenith"
        )
        .semantics { role = Role.Button }
    ) {
      Column(modifier = Modifier.padding(24.dp)) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.Top
        ) {
          Icon(
            imageVector = Icons.Outlined.RocketLaunch,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimaryContainer,
            modifier = Modifier.size(32.dp)
          )
          Surface(
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            shape = CircleShape
          ) {
            Text(
              text = "FEATURED",
              style = MaterialTheme.typography.labelSmall,
              color = MaterialTheme.colorScheme.primaryContainer,
              modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
              fontWeight = FontWeight.Bold
            )
          }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
          text = "Project Zenith",
          style = MaterialTheme.typography.titleLarge,
          color = MaterialTheme.colorScheme.onPrimaryContainer
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
          text = "A high-performance cloud monitoring dashboard built with React and Go.",
          style = MaterialTheme.typography.bodyMedium,
          color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
          SkillChip("TYPESCRIPT")
          SkillChip("AWS")
        }
      }
    }

    // Grid row
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
      StatsCard(
        icon = Icons.Outlined.Terminal,
        title = "Tech Stack",
        subtitle = "12+ Technologies",
        modifier = Modifier.weight(1f)
      )
      StatsCard(
        icon = Icons.Outlined.HistoryEdu,
        title = "Experience",
        subtitle = "5 Years Active",
        modifier = Modifier.weight(1f)
      )
    }

    // Contact Card
    Card(
      shape = RoundedCornerShape(28.dp),
      colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
      border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
      modifier = Modifier
        .fillMaxWidth()
        .clickable(
            onClick = { },
            onClickLabel = "Get in touch"
        )
        .semantics { role = Role.Button }
    ) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Row(
          horizontalArrangement = Arrangement.spacedBy(16.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Box(
            modifier = Modifier
              .size(40.dp)
              .background(MaterialTheme.colorScheme.primary, CircleShape),
            contentAlignment = Alignment.Center
          ) {
            Icon(
              imageVector = Icons.Outlined.Mail,
              contentDescription = "Mail",
              tint = MaterialTheme.colorScheme.onPrimary,
              modifier = Modifier.size(20.dp)
            )
          }
          Column {
            Text(
              text = "Get in touch",
              style = MaterialTheme.typography.titleMedium,
              color = MaterialTheme.colorScheme.onSurface
            )
            Text(
              text = "Available for hire",
              style = MaterialTheme.typography.bodySmall,
              color = MaterialTheme.colorScheme.onSurfaceVariant
            )
          }
        }
        Icon(
          imageVector = Icons.Outlined.ChevronRight,
          contentDescription = "Go",
          tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
      }
    }
  }
}

@Composable
fun ProjectsSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = "Projects",
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.onBackground
        )
        DetailedProjectCard(
            title = "Project Zenith",
            description = "A high-performance cloud monitoring dashboard built with React and Go. Features real-time data streaming, customizable widgets, and fine-grained access control. Deployed on AWS.",
            technologies = listOf("React", "Go", "TypeScript", "AWS", "WebSockets"),
            linkText = "Live Demo",
            imageIcon = Icons.Outlined.Cloud,
            projectImages = listOf(
                "https://images.unsplash.com/photo-1551288049-bebda4e38f71?auto=format&fit=crop&w=600&q=80",
                "https://images.unsplash.com/photo-1460925895917-afdab827c52f?auto=format&fit=crop&w=600&q=80",
                "https://images.unsplash.com/photo-1504868584819-f8e8b4b6d7e3?auto=format&fit=crop&w=600&q=80"
            )
        )
        DetailedProjectCard(
            title = "CryptoDash",
            description = "Real-time cryptocurrency tracking dashboard. Uses Flow and Coroutines for state management, with custom canvas charts for price history visualization.",
            technologies = listOf("Kotlin", "Jetpack Compose", "Coroutines", "Retrofit"),
            linkText = "Source Code",
            imageIcon = Icons.Outlined.CurrencyBitcoin,
            projectImages = listOf(
                "https://images.unsplash.com/photo-1621416894569-0f39ed31d247?auto=format&fit=crop&w=600&q=80",
                "https://images.unsplash.com/photo-1526304640581-d334cdbbf45e?auto=format&fit=crop&w=600&q=80"
            )
        )
    }
}

@Composable
fun DetailedProjectCard(
    title: String,
    description: String,
    technologies: List<String>,
    linkText: String,
    imageIcon: ImageVector,
    projectImages: List<String> = emptyList()
) {
    Card(
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.5f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = imageIcon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(48.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = "Key Technologies",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            @OptIn(ExperimentalLayoutApi::class)
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                technologies.forEach { tech ->
                    SkillChip(tech)
                }
            }
            
            if (projectImages.isNotEmpty()) {
                Spacer(modifier = Modifier.height(16.dp))
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(projectImages) { imageUrl ->
                        AsyncImage(
                            model = imageUrl,
                            contentDescription = "Project image",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(240.dp, 160.dp)
                                .clip(RoundedCornerShape(12.dp))
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable(
                        onClick = { },
                        onClickLabel = "Open $linkText"
                    )
                    .semantics { role = Role.Button }
            ) {
                Icon(
                    imageVector = Icons.Outlined.Link,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = linkText,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
fun AboutSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.jaakko_avatar),
            contentDescription = "Profile Picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(160.dp)
                .clip(CircleShape)
                .border(4.dp, MaterialTheme.colorScheme.primaryContainer, CircleShape)
        )
        
        Text(
            text = "Skills & Expertise",
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.align(Alignment.Start)
        )
        SkillCategory(
            title = "Programming Languages",
            skills = listOf(
                Pair("Kotlin", 0.9f),
                Pair("Java", 0.8f),
                Pair("TypeScript", 0.7f),
                Pair("Go", 0.6f)
            )
        )
        SkillCategory(
            title = "Frameworks & UI",
            skills = listOf(
                Pair("Jetpack Compose", 0.95f),
                Pair("React", 0.8f),
                Pair("Coroutines & Flow", 0.85f),
                Pair("Tailwind CSS", 0.9f)
            )
        )
        SkillCategory(
            title = "Tools & Infrastructure",
            skills = listOf(
                Pair("Git & GitHub", 0.9f),
                Pair("Firebase", 0.8f),
                Pair("AWS", 0.65f),
                Pair("Docker", 0.7f)
            )
        )
    }
}

@Composable
fun SkillCategory(title: String, skills: List<Pair<String, Float>>) {
    Card(
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(16.dp))
            skills.forEach { (skill, proficiency) ->
                var targetProgress by remember { mutableFloatStateOf(0f) }
                val progress by animateFloatAsState(
                    targetValue = targetProgress,
                    animationSpec = tween(durationMillis = 1000),
                    label = "$skill progress"
                )

                LaunchedEffect(proficiency) {
                    targetProgress = proficiency
                }

                Column(
                    modifier = Modifier
                        .padding(bottom = 12.dp)
                        .semantics(mergeDescendants = true) {
                            progressBarRangeInfo = ProgressBarRangeInfo(progress, 0f..1f)
                            stateDescription = "${(proficiency * 100).toInt()}% proficiency"
                        }
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = skill,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    LinearProgressIndicator(
                        progress = { progress },
                        modifier = Modifier.fillMaxWidth().height(6.dp).clip(RoundedCornerShape(3.dp)),
                        color = MaterialTheme.colorScheme.primary,
                        trackColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                }
            }
        }
    }
}

@Composable
fun ContactSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = "Contact",
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.onBackground
        )
        Card(
            shape = RoundedCornerShape(28.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
            modifier = Modifier
                .fillMaxWidth()
                .clickable(
                    onClick = { },
                    onClickLabel = "Email Jaakko"
                )
                .semantics { role = Role.Button }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(MaterialTheme.colorScheme.primary, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Mail,
                            contentDescription = "Mail",
                            tint = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    Column {
                        Text(
                            text = "Email Me",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "jaakko.kkallio@gmail.com",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }

        Card(
            shape = RoundedCornerShape(28.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
            modifier = Modifier
                .fillMaxWidth()
                .clickable(
                    onClick = { },
                    onClickLabel = "Connect on LinkedIn"
                )
                .semantics { role = Role.Button }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(MaterialTheme.colorScheme.secondaryContainer, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Link,
                            contentDescription = "LinkedIn",
                            tint = MaterialTheme.colorScheme.onSecondaryContainer,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    Column {
                        Text(
                            text = "LinkedIn",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "Let's connect",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SkillChip(text: String) {
  Surface(
    shape = RoundedCornerShape(6.dp),
    color = MaterialTheme.colorScheme.surface.copy(alpha = 0.4f)
  ) {
    Text(
      text = text,
      style = MaterialTheme.typography.labelSmall,
      color = MaterialTheme.colorScheme.onPrimaryContainer,
      modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
      fontWeight = FontWeight.SemiBold
    )
  }
}

@Composable
fun StatsCard(icon: ImageVector, title: String, subtitle: String, modifier: Modifier = Modifier) {
  Card(
    shape = RoundedCornerShape(28.dp),
    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.5f)),
    modifier = modifier
        .clickable(
            onClick = { },
            onClickLabel = "View details for $title"
        )
        .semantics { role = Role.Button }
  ) {
    Column(modifier = Modifier.padding(20.dp)) {
      Icon(
        imageVector = icon,
        contentDescription = null,
        tint = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(bottom = 8.dp)
      )
      Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.onBackground
      )
      Text(
        text = subtitle,
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant
      )
    }
  }
}

@Composable
fun BottomNavigationBar(selectedTab: String, onTabSelected: (String) -> Unit) {
  Surface(
    color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.5f),
    tonalElevation = 0.dp
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp, vertical = 12.dp)
        .windowInsetsPadding(WindowInsets.navigationBars),
      horizontalArrangement = Arrangement.SpaceAround,
      verticalAlignment = Alignment.CenterVertically
    ) {
      NavBarItem(icon = Icons.Outlined.Home, label = "Home", isSelected = selectedTab == "Home", onClick = { onTabSelected("Home") })
      NavBarItem(icon = Icons.Outlined.GridView, label = "Projects", isSelected = selectedTab == "Projects", onClick = { onTabSelected("Projects") })
      NavBarItem(icon = Icons.Outlined.Person, label = "About", isSelected = selectedTab == "About", onClick = { onTabSelected("About") })
      NavBarItem(icon = Icons.Outlined.Mail, label = "Contact", isSelected = selectedTab == "Contact", onClick = { onTabSelected("Contact") })
    }
  }
}

@Composable
fun NavBarItem(icon: ImageVector, label: String, isSelected: Boolean, onClick: () -> Unit) {
  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier
        .clickable(
            onClick = onClick,
            onClickLabel = "Navigate to $label"
        )
        .semantics {
            role = Role.Tab
            selected = isSelected
        }
  ) {
    Box(
      modifier = Modifier
        .clip(RoundedCornerShape(16.dp))
        .background(
          if (isSelected) MaterialTheme.colorScheme.secondaryContainer else Color.Transparent
        )
        .padding(horizontal = 20.dp, vertical = 6.dp)
    ) {
      Icon(
        imageVector = icon,
        contentDescription = label,
        tint = if (isSelected) MaterialTheme.colorScheme.onSecondaryContainer else MaterialTheme.colorScheme.onSurfaceVariant
      )
    }
    Text(
      text = label,
      style = MaterialTheme.typography.labelSmall,
      color = if (isSelected) MaterialTheme.colorScheme.onBackground else MaterialTheme.colorScheme.onSurfaceVariant,
      modifier = Modifier.padding(top = 4.dp),
      fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Medium
    )
  }
}


