package com.melvin.contacts.core.data

import com.melvin.contacts.core.domain.Contact

fun Contact.toEntity(key: String? = null) =
    ContactEntity(
        key = key ?: this.key,
        firstName = firstName,
        lastName = lastName,
        companyName = companyName,
        address = address,
        city = city,
        country = country,
        state = state,
        zip = zip,
        phone = phone,
        phone1 = phone1,
        email = email,
    )

fun ContactEntity.toDomain() =
    Contact(
        key = key,
        firstName = firstName,
        lastName = lastName,
        companyName = companyName,
        address = address,
        city = city,
        country = country,
        state = state,
        zip = zip,
        phone = phone,
        phone1 = phone1,
        email = email,
    )