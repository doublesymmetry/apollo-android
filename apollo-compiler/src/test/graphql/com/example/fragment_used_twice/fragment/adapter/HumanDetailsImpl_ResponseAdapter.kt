// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.fragment_used_twice.fragment.adapter

import com.apollographql.apollo.api.ResponseAdapterCache
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.StringResponseAdapter
import com.apollographql.apollo.api.internal.json.JsonReader
import com.apollographql.apollo.api.internal.json.JsonWriter
import com.example.fragment_used_twice.fragment.HumanDetailsImpl
import com.example.fragment_used_twice.type.CustomScalars
import kotlin.Any
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
class HumanDetailsImpl_ResponseAdapter(
  responseAdapterCache: ResponseAdapterCache
) : ResponseAdapter<HumanDetailsImpl.Data> {
  val CharacterDataAdapter: CharacterData =
      com.example.fragment_used_twice.fragment.adapter.HumanDetailsImpl_ResponseAdapter.CharacterData(responseAdapterCache)

  val OtherDataAdapter: OtherData =
      com.example.fragment_used_twice.fragment.adapter.HumanDetailsImpl_ResponseAdapter.OtherData(responseAdapterCache)

  override fun fromResponse(reader: JsonReader): HumanDetailsImpl.Data {
    reader.beginObject()
    check(reader.nextName() == "__typename")
    val typename = reader.nextString()

    return when(typename) {
      "Human" -> CharacterDataAdapter.fromResponse(reader, typename)
      else -> OtherDataAdapter.fromResponse(reader, typename)
    }
    .also { reader.endObject() }
  }

  override fun toResponse(writer: JsonWriter, value: HumanDetailsImpl.Data) {
    when(value) {
      is HumanDetailsImpl.Data.CharacterData -> CharacterDataAdapter.toResponse(writer, value)
      is HumanDetailsImpl.Data.OtherData -> OtherDataAdapter.toResponse(writer, value)
    }
  }

  class CharacterData(
    responseAdapterCache: ResponseAdapterCache
  ) {
    private val stringAdapter: ResponseAdapter<String> = StringResponseAdapter

    private val dateAdapter: ResponseAdapter<Any> =
        responseAdapterCache.responseAdapterFor<Any>(CustomScalars.Date)

    fun fromResponse(reader: JsonReader, __typename: String?): HumanDetailsImpl.Data.CharacterData {
      var __typename: String? = __typename
      var name: String? = null
      var birthDate: Any? = null
      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> __typename = stringAdapter.fromResponse(reader)
          1 -> name = stringAdapter.fromResponse(reader)
          2 -> birthDate = dateAdapter.fromResponse(reader)
          else -> break
        }
      }
      return HumanDetailsImpl.Data.CharacterData(
        __typename = __typename!!,
        name = name!!,
        birthDate = birthDate!!
      )
    }

    fun toResponse(writer: JsonWriter, value: HumanDetailsImpl.Data.CharacterData) {
      writer.beginObject()
      writer.name("__typename")
      stringAdapter.toResponse(writer, value.__typename)
      writer.name("name")
      stringAdapter.toResponse(writer, value.name)
      writer.name("birthDate")
      dateAdapter.toResponse(writer, value.birthDate)
      writer.endObject()
    }

    companion object {
      val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.Typename,
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
          fieldName = "name",
        ),
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("Date")),
          fieldName = "birthDate",
        )
      )

      val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
    }
  }

  class OtherData(
    responseAdapterCache: ResponseAdapterCache
  ) {
    private val stringAdapter: ResponseAdapter<String> = StringResponseAdapter

    fun fromResponse(reader: JsonReader, __typename: String?): HumanDetailsImpl.Data.OtherData {
      var __typename: String? = __typename
      var name: String? = null
      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> __typename = stringAdapter.fromResponse(reader)
          1 -> name = stringAdapter.fromResponse(reader)
          else -> break
        }
      }
      return HumanDetailsImpl.Data.OtherData(
        __typename = __typename!!,
        name = name!!
      )
    }

    fun toResponse(writer: JsonWriter, value: HumanDetailsImpl.Data.OtherData) {
      writer.beginObject()
      writer.name("__typename")
      stringAdapter.toResponse(writer, value.__typename)
      writer.name("name")
      stringAdapter.toResponse(writer, value.name)
      writer.endObject()
    }

    companion object {
      val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.Typename,
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
          fieldName = "name",
        )
      )

      val RESPONSE_NAMES: List<String> = RESPONSE_FIELDS.map { it.responseName }
    }
  }
}