package ru.android.hyrulecompendiummvvm.data.mapper

import ru.android.hyrulecompendiummvvm.base.mapper.Mapper
import ru.android.hyrulecompendiummvvm.data.model.hyrule_responses.HyruleInfoResponses
import ru.android.hyrulecompendiummvvm.data.model.hyrule_body.*

class HyruleInfoDataMapper :
    Mapper<HyruleInfoResponses, HyruleInfoBody> {

    override fun map(origin: HyruleInfoResponses) = HyruleInfoBody(
        data = origin.data?.map { it ->
            HyruleDataBody(
                id = it.id,
                category = it.category,
                name = it.name,
                image = it.image,
                description = it.description,
                commonLocations = it.commonLocations,
                attack = it.attack,
                defense = it.defense,
                drops = it.drops,
                cookingEffect = it.cookingEffect,
                heartsRecovered = it.heartsRecovered
            )
        }
    )

}