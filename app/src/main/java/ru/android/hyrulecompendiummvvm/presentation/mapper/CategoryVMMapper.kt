package ru.android.hyrulecompendiummvvm.presentation.mapper

import ru.android.hyrulecompendiummvvm.base.mapper.Mapper
import ru.android.hyrulecompendiummvvm.data.model.hyrule_body.HyruleInfoBody
import ru.android.hyrulecompendiummvvm.presentation.model.*

class CategoryVMMapper : Mapper<HyruleInfoBody, HyruleInfo> {

    override fun map(origin: HyruleInfoBody) = HyruleInfo(
        data = origin.data?.map { it ->
            HyruleData(
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