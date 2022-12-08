/*
IP címek és domain nevek
    Készíts egy dns.NameServer osztályt, amely, akárcsak egy domain name server, listában tárolja, hogy milyen IP-címhez milyen domain név tartozik! Legyen egy private static nested class (pl. DnsEntry néven), amely egy név, IP-cím párost tartalmaz és a NameServer osztály listája ilyen típusú adatokat tartalmazzon!
        Lehessen hozzáadni új név, IP-cím párost az addEntry(String hostName, String hostIp) metódussal, ami dobjon IllegalArgumentException kivételt Already exists szöveggel, ha már van ilyen IP-cím, vagy név!
        Lehessen törölni egy bejegyzést a nevet megadva a removeEntryByName metódussal, ha nincs ilyen nevű, akkor ne történjen semmi!
        Lehessen törölni IP-cím alapján, a removeEntryByIp metódussal! Ha nincs ilyen IP-címmel rendelkező, akkor ne történjen semmi!
        Lehessen megkapni az adott névhez tartozó IP-címet (getIpByName metódussal)! A metódus dobjon IllegalArgumentException kivételt Element not found szöveggel, ha nincs ilyen!
        Lehessen megkapni az adott ip-hez tartozó nevet (getNameByIp metódussal), dobjon IllegalArgumentException kivételt Element not found szöveggel ha nincs ilyen!
*/

package nestedclasses.dns;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NameServer {

    private static final String ELEMENT_NOT_FOUND = "Element not found";
    private static final String ALREADY_EXIST = "Already exists";

    List<DnsEntry> dnsEntryList = new ArrayList<>();

    public void addEntry(String name, String ipAddress) {
        Optional<DnsEntry> dnsEntry = dnsEntryList.stream().filter(e -> e.name().equals(name) || e.ipAddress().equals(ipAddress)).findAny();
        if (dnsEntry.isPresent()) throw new IllegalArgumentException(ALREADY_EXIST);
        dnsEntryList.add(new DnsEntry(name, ipAddress));
    }

    public void removeEntryByName(String name) {
        Optional<DnsEntry> dnsEntry = dnsEntryList.stream().filter(e -> e.name().equals(name)).findAny();
        dnsEntry.ifPresent(entry -> dnsEntryList.remove(entry));
    }

    public void removeEntryByIp(String ipAddress) {
        Optional<DnsEntry> dnsEntry = dnsEntryList.stream().filter(e -> e.ipAddress().equals(ipAddress)).findAny();
        dnsEntry.ifPresent(entry -> dnsEntryList.remove(entry));
    }

    public String getIpByName(String name) {
        Optional<DnsEntry> dnsEntry = dnsEntryList.stream().filter(e -> e.name().equals(name)).findAny();
        if (dnsEntry.isPresent()) return dnsEntry.get().ipAddress();
        throw new IllegalArgumentException(ELEMENT_NOT_FOUND);
    }

    public String getNameByIp(String ipAddress) {
        Optional<DnsEntry> dnsEntry = dnsEntryList.stream().filter(e -> e.ipAddress().equals(ipAddress)).findAny();
        if (dnsEntry.isPresent()) return dnsEntry.get().name();
        throw new IllegalArgumentException(ELEMENT_NOT_FOUND);
    }

    private record DnsEntry(String name, String ipAddress) {
    }
}
