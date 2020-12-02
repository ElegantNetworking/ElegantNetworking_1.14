package hohserg.elegant.networking.impl;

import io.netty.buffer.ByteBuf;

import java.nio.charset.StandardCharsets;

public interface ISerializer<Packet> {
    void serialize(Packet value, ByteBuf acc);

    Packet unserialize(ByteBuf buf);

    int packetId();

    default void serializeBooleanGeneric(boolean value, ByteBuf acc) {
        acc.writeBoolean(value);
    }

    default void serializeByteGeneric(byte value, ByteBuf acc) {
        acc.writeByte(value);
    }

    default void serializeShortGeneric(short value, ByteBuf acc) {
        acc.writeShort(value);
    }

    default void serializeIntGeneric(int value, ByteBuf acc) {
        acc.writeInt(value);
    }

    default void serializeLongGeneric(long value, ByteBuf acc) {
        acc.writeLong(value);
    }

    default void serializeCharGeneric(char value, ByteBuf acc) {
        acc.writeChar(value);
    }

    default void serializeFloatGeneric(float value, ByteBuf acc) {
        acc.writeFloat(value);
    }

    default void serializeDoubleGeneric(double value, ByteBuf acc) {
        acc.writeDouble(value);
    }

    default void serializeStringGeneric(String value, ByteBuf acc) {
        byte[] utf8Bytes = value.getBytes(StandardCharsets.UTF_8);
        acc.writeInt(utf8Bytes.length);
        acc.writeBytes(utf8Bytes);
    }

    default boolean unserializeBooleanGeneric(ByteBuf buf) {
        return buf.readBoolean();
    }

    default byte unserializeByteGeneric(ByteBuf buf) {
        return buf.readByte();
    }

    default short unserializeShortGeneric(ByteBuf buf) {
        return buf.readShort();
    }

    default int unserializeIntGeneric(ByteBuf buf) {
        return buf.readInt();
    }

    default long unserializeLongGeneric(ByteBuf buf) {
        return buf.readLong();
    }

    default char unserializeCharGeneric(ByteBuf buf) {
        return buf.readChar();
    }

    default float unserializeFloatGeneric(ByteBuf buf) {
        return buf.readFloat();
    }

    default double unserializeDoubleGeneric(ByteBuf buf) {
        return buf.readDouble();
    }

    default String unserializeStringGeneric(ByteBuf buf) {
        int len = buf.readInt();
        String str = buf.toString(buf.readerIndex(), len, StandardCharsets.UTF_8);
        buf.readerIndex(buf.readerIndex() + len);
        return str;
    }
}
