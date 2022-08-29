import content.ContentAccess
import content.ContentFormat
import content.ContentId
import content.ContentInfo
import content.ContentUpdateStatus
import content.contentInfo
import org.jetbrains.compose.web.css.em

object Const {
    const val TITLE = "Слова"
    const val EMAIL = "justeveho@gmail.com"
    const val GITHUB = "https://github.com/cold-winter-snow"
    const val NOT_FOUND = "Page not found"
    const val LOADING = "Loading..."
    const val LOAD_FAILED = "Failed to load content. Please contact with developer $EMAIL"
    const val SHOW_FOOTER_CONTENT = false
    const val STATUS_UPDATING = "Regularly updated"
    const val STATUS_DRAFT = "Draft"
    const val SOURCE = "source"
}

object Registry {
    val content: Map<ContentId, ContentInfo> = data.associateBy { it.id }

    val substitution: Map<String, ContentId> = buildMap {
        data.forEach { info ->
            info.permanentShortNames.forEach { name ->
                require(name !in this)
                put(name, info.id)
            }
            info.shortNames.forEach { name ->
                require(name !in this)
                put(name, info.id)
            }
        }
    }
}

// Assign production data instead of test one
private val data by lazy { realData }

private val testData = listOf(
    contentInfo {
        access = ContentAccess.Common
        name = "test1"
        status = ContentUpdateStatus.Done("15.08.2022")
        format = ContentFormat.TXT
        hideTitle = true
    },
    contentInfo {
        name = "test2"
        format = ContentFormat.TXT
    },
    contentInfo {
        title = "Very interesting article"
        access = ContentAccess.Common
        name = "test3"
        status = ContentUpdateStatus.Draft
        format = ContentFormat.MD
    },
    contentInfo {
        access = ContentAccess.Extended
        name = "test2"
        format = ContentFormat.TXT
        permanentShortNames.add("short")
        status = ContentUpdateStatus.Draft
    },
    contentInfo {
        title = "Failed to load data"
        access = ContentAccess.Common
        name = "eesdfyguhijklkjb"
        format = ContentFormat.TXT
    },
    contentInfo {
        title = "Kotlin"
        access = ContentAccess.Common
        name = "kotlin"
        format = ContentFormat.MD
        location = "https://raw.githubusercontent.com/JetBrains/kotlin/master/ReadMe.md"
        status = ContentUpdateStatus.Continuous
        source = "https://github.com/JetBrains/kotlin"
    },
)

private val realData = listOf(
    contentInfo {
        title = "Храм"
        name = "1"
        format = ContentFormat.TXT
    },
    contentInfo {
        hideTitle = true
        title = "Machine"
        name = "2"
        format = ContentFormat.TXT
    },
    contentInfo {
        hideTitle = true
        name = "3"
        format = ContentFormat.TXT
    },
    contentInfo {
        hideTitle = true
        title = "Путешествие"
        name = "4"
        format = ContentFormat.TXT
    },
    contentInfo {
        hideTitle = true
        name = "5"
        format = ContentFormat.TXT
    },
    contentInfo {
        hideTitle = true
        name = "6"
        format = ContentFormat.TXT
    },
    contentInfo {
        hideTitle = true
        title = "Страны, города"
        name = "7"
        format = ContentFormat.TXT
    },
    contentInfo {
        hideTitle = true
        name = "8"
        format = ContentFormat.TXT
    },
    contentInfo {
        hideTitle = true
        name = "9"
        format = ContentFormat.TXT
    },
    contentInfo {
        hideTitle = true
        title = "Ад Хаос Пустота"
        name = "10"
        format = ContentFormat.TXT
    },
    contentInfo {
        hideTitle = true
        name = "Было сердце одно"
        format = ContentFormat.TXT
    },
    contentInfo {
        hideTitle = true
        name = "в никуда"
        format = ContentFormat.TXT
    },
    contentInfo {
        hideTitle = true
        name = "В синем небе"
        format = ContentFormat.TXT
    },
    contentInfo {
        hideTitle = true
        name = "В сто тысяч первый раз"
        format = ContentFormat.TXT
    },
    contentInfo {
        hideTitle = true
        name = "В тот вечер растворились звёзды"
        format = ContentFormat.TXT
    },
    contentInfo {
        hideTitle = true
        name = "В тумане пустынных видений"
        format = ContentFormat.TXT
    },
    contentInfo {
        hideTitle = true
        name = "Выход"
        format = ContentFormat.TXT
    },
    contentInfo {
        hideTitle = true
        name = "Где"
        format = ContentFormat.TXT
    },
    contentInfo {
        hideTitle = true
        name = "Дождь"
        format = ContentFormat.TXT
    },
    contentInfo {
        hideTitle = true
        name = "другой мир"
        format = ContentFormat.TXT
    },
    contentInfo {
        hideTitle = true
        name = "ждать"
        format = ContentFormat.TXT
    },
    contentInfo {
        hideTitle = true
        name = "Зачем писать заметки в телефоне"
        format = ContentFormat.TXT
    },
    contentInfo {
        hideTitle = true
        name = "Крик"
        format = ContentFormat.TXT
    },
    contentInfo {
        hideTitle = true
        name = "Меч"
        format = ContentFormat.TXT
    },
    contentInfo {
        name = "Молитвы неизвестному"
        format = ContentFormat.TXT
    },
    contentInfo {
        name = "На дальний берег"
        format = ContentFormat.TXT
    },
    contentInfo {
        name = "Обычно"
        format = ContentFormat.TXT
    },
    contentInfo {
        name = "Одинокий монумент"
        format = ContentFormat.TXT
    },
    contentInfo {
        name = "Он кидал сердце в небо"
        format = ContentFormat.TXT
    },
    contentInfo {
        name = "Он смотрел на закат Вселенной"
        format = ContentFormat.TXT
    },
    contentInfo {
        name = "Поэзия"
        format = ContentFormat.TXT
    },
    contentInfo {
        name = "Сказки уходят"
        format = ContentFormat.TXT
    },
    contentInfo {
        name = "Слова..."
        format = ContentFormat.TXT
    },
    contentInfo {
        name = "Смерти путь"
        format = ContentFormat.TXT
    },
    contentInfo {
        name = "Строки"
        format = ContentFormat.TXT
    },
    contentInfo {
        name = "Зачем писать заметки в телефоне"
        format = ContentFormat.TXT
    },
    contentInfo {
        name = "Только лишь вслед"
        format = ContentFormat.TXT
    },
    contentInfo {
        name = "Ты забыл"
        format = ContentFormat.TXT
    },
    contentInfo {
        name = "Ты неисправим"
        format = ContentFormat.TXT
    },
    contentInfo {
        name = "Это же прошлое"
        format = ContentFormat.TXT
    },
    contentInfo {
        name = "Я бы"
        format = ContentFormat.TXT
    }
).map {
    it.copy(contentWidth = 32.5.em)
}
