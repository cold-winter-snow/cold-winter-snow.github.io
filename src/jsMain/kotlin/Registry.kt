object Storage {
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

value class ContentTitle(val v: String) {
    init {
        require(v.isNotBlank())
    }
}

value class ContentDate(val v: String?) {
    init {
        require(v == null || v.isNotBlank())
    }

    override fun toString(): String = v.orEmpty()
}

val ContentDate.isEmpty: Boolean
    get() = v == null

val ContentDate.isNotEmpty: Boolean
    get() = !isEmpty

data class ContentInfo(
    val title: ContentTitle?,
    val date: ContentDate,
    val id: ContentId,
    val access: ContentAccess,
    val permanentShortNames: List<String>,
    val shortNames: List<String>,
    val hideTitle: Boolean,
) {
    val titleNotNull: String
        get() = title?.v ?: id.name.v
}

private class ContentInfoBuilder {
    var title: String? = null
    var access = ContentAccess.values().maxOf { it }
    var dir = emptyList<String>()
    var name: String? = null
    var date: String? = null
    var format: ContentFormat? = null
    val permanentShortNames = mutableListOf<String>() // Do not remove permanent names!
    val shortNames = mutableListOf<String>()
    var hideTitle: Boolean = false

    fun build() = ContentInfo(
        title?.let { ContentTitle(it) },
        ContentDate(date),
        ContentId(
            ContentDir(dir),
            ContentName(name!!),
            format!!
        ),
        access,
        permanentShortNames = permanentShortNames,
        shortNames = shortNames,
        hideTitle = hideTitle
    )
}

private inline fun contentInfo(block: ContentInfoBuilder.() -> Unit): ContentInfo =
    ContentInfoBuilder().apply(block).build()

// Assign production data instead of test one
private val data by lazy { realData }

private val testData = listOf(
    contentInfo {
        access = ContentAccess.Common
        name = "test1"
        date = "15.08.2022"
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
        date = "15.08.2022"
        format = ContentFormat.MD
    },
    contentInfo {
        access = ContentAccess.Extended
        name = "test2"
        format = ContentFormat.TXT
        permanentShortNames.add("short")
    },
    contentInfo {
        title = "Failed to load data"
        access = ContentAccess.Common
        name = "eesdfyguhijklkjb"
        format = ContentFormat.TXT
    }
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
)
