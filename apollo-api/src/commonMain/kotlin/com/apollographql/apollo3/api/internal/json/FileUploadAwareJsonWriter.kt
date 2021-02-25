package com.apollographql.apollo3.api.internal.json

import com.apollographql.apollo3.api.Upload

class FileUploadAwareJsonWriter(private val wrappedWriter: BufferedSinkJsonWriter): JsonWriter {
  private val uploads = mutableMapOf<String, Upload>()

  init {
    wrappedWriter.serializeNulls = true
  }
  fun collectedUploads(): Map<String, Upload> = uploads

  override fun beginArray() = apply {
    wrappedWriter.beginArray()
  }

  override fun endArray() = apply {
    wrappedWriter.endArray()
  }

  override fun beginObject() = apply {
    wrappedWriter.beginObject()
  }

  override fun endObject() = apply {
    wrappedWriter.endObject()
  }

  override fun name(name: String) = apply {
    wrappedWriter.name(name)
  }

  override fun value(value: String) = apply {
    wrappedWriter.value(value)
  }

  override fun value(value: Boolean) = apply {
    wrappedWriter.value(value)
  }

  override fun value(value: Double) = apply {
    wrappedWriter.value(value)
  }

  override fun value(value: Int) = apply {
    wrappedWriter.value(value)
  }

  override fun value(value: Upload) = apply {
    uploads[wrappedWriter.path] = value
    wrappedWriter.nullValue()
  }

  override fun nullValue() = apply {
    wrappedWriter.nullValue()
  }

  override fun close() {
    wrappedWriter.close()
  }

  override fun flush() {
    wrappedWriter.flush()
  }
}