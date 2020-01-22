## SYT EK734 DezSys/Middleware Engineering "Interface Development using Naming Services" (MICT)

## Einführung

Diese Übung soll die Verwendung von Namensdiensten in JAVA und auf OS-Ebene (Linux) vertiefen.

## Ziele

Das Ziel dieser Übung ist die Funktionsweise eines Namens/Verzeichnisdienstes zu verstehen und Erfahrungen mit der Administration zu sammeln. Ebenso soll die Verwendung des Dienstes aus einer Anwendung heraus mit Hilfe der JNDI geübt werden und auch ein CLI zur Administration angewendet werden.

## Voraussetzungen

- Grundlagen Namensdienst/Verzeichnisdienst
- Administration eines LDAP Dienstes
- Verwendung von Commandline Werkzeugen fuer LDAP (LDAPSEARCH)
- Grundlagen der JNDI API für eine JAVA Implementierung
- Verwendung einer virtuellen Instanz für den Betrieb des Verzeichnisdienstes

## Aufgabenstellung

Mit Hilfe der zur Verfuegung gestellten VM wird ein vorkonfiguriertes LDAP Service zur Verfuegung gestellt. Dieser Verzeichnisdienst soll um folgende Eintraege erweitert werden. Das verwendete Namensschema (eg. group.service1 oder vorname.nachname) soll fuer alle Eintraege verwendet werden.

- 2 Posix Groups (beliebe Zuweisung von UserIDs)
- 5 User Accounts



Mit Hilfe des LINUX CLI "LDAPSEARCH" sollen 3 Suchanfragen durchgefuehrt und das Ergebnis dokumentiert werden. Hier ein Beispiel dazu:

```
ldapsearch
 -h 192.168.0.8 -p 389 -D "cn=max.mustermann,dc=nodomain,dc=com" -W -b 
"cn=group.service2,dc=nodomain,dc=com" memberUid
```

Weiters soll eine Java-Applikationen zur Anbindung an das LDAP-Verzeichnis entwickelt werden. Folgende Fragestellungen stehen dabei im Mittelpunkt:

- Gibt es einen Eintrag mit dem DN*: cn=max.mustermann,dc=nodomain,dc=com**
  *
- Wie lautet der GivenName dieses Eintrages?
- Implementieren Sie eine Authentisierung Anfrage (bind) an das LDAP-Verzeichnis und protokollieren Sie das Ergebnis.

## Bewertung

Gruppengrösse: 1 Person

Bewertung: 8 Punkte
\- Dokumentation der einzelnen Arbeitsschritte im Protokoll (1 Punkte)
\- Anlegen von 2 Gruppen und 5 User Accounts (1 Punkte)
\- Dokumentation von 3 LDAPSEARCH Befehlen (2 Punkte)
\- JNDI Implementierung (4 Punkte)