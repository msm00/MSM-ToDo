package com.msm.msmtodo.fake

import com.msm.msmtodo.model.Link
import com.msm.msmtodo.model.Msm
import com.msm.msmtodo.model.MsmResponse

object FakeDataSource {
    const val id1: Int = 3
    const val name1: String = "Ursula"
    const val description1: String = "MonsterClock"

    const val id2: Int = 6
    const val name2: String = "Olsson"
    const val description2: String = "Petersonite"

    val itemsList: List<Msm> = listOf(
        Msm(id = id1, name = name1, description = description1),
        Msm(id = id2, name = name2, description = description2)
    )

    val link = Link("www.seznam.cz", "aa.fo.com")
    val link2 = Link("www.googel.cz", "aa.fop.com")

    val links : List<Link> = listOf(link, link2)

    val itemsFromDB : MsmResponse = MsmResponse(itemsList, true, limit = 5, offset = 4, count = 2, links = links)
}