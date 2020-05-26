import com.google.common.primitives.UnsignedLong;
import entity.Message;
import entity.Packet;

public class Main {
    public static void main(String[] args) {

        UnsignedLong moreThanLongbPktId = UnsignedLong.valueOf(Long.MAX_VALUE);
        moreThanLongbPktId = moreThanLongbPktId.plus(UnsignedLong.valueOf("2305"));

        System.out.println("UnsignedLong moreThanLongbPktId: " + moreThanLongbPktId.toString());
        System.out.println("long moreThanLongbPktId: " + moreThanLongbPktId.longValue());

        Message testMessage = new Message(3, 4, "test");
        Packet packet = new Packet((byte) 1, moreThanLongbPktId, testMessage);

        try {
            byte[] encodedPacket = packet.toPacket();
            System.out.println("Out packet: ");
            System.out.println(packet);

            Packet decodedPacket = new Packet(encodedPacket);
            System.out.println("In packet: ");
            System.out.println(decodedPacket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




