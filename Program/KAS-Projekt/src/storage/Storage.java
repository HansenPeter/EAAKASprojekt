package storage;

import java.time.LocalDate;
import java.util.ArrayList;

import application.model.Beboelse;
import application.model.Deltager;
import application.model.Konference;
import application.model.Organisation;
import application.service.Service;

public class Storage {
    private static ArrayList<Beboelse> beboelser = new ArrayList<>();
    private static ArrayList<Deltager> deltagere = new ArrayList<>();
    private static ArrayList<Organisation> organisations = new ArrayList<>();
    private static ArrayList<Konference> konferencer = new ArrayList<>();

    // ----Beboelse----//

    public static ArrayList<Beboelse> getBeboelses() {
        return new ArrayList<>(beboelser);
    }

    public static void addBeboelse(Beboelse beboelse) {
        beboelser.add(beboelse);
    }

    public static void removeBeboelse(Beboelse beboelse) {
        beboelser.remove(beboelse);
    }
    // ----Deltager----//

    public static ArrayList<Deltager> getDeltagers() {
        return new ArrayList<>(deltagere);
    }

    public static void addDeltager(Deltager deltager) {
        deltagere.add(deltager);
    }

    public static void removeDeltager(Deltager deltager) {
        deltagere.remove(deltager);
    }
    // ----Organisation----//

    public static ArrayList<Organisation> getOrganisations() {
        return new ArrayList<>(organisations);
    }

    public static void addOrganisation(Organisation organisation) {
        organisations.add(organisation);
    }

    public static void removeOrganisation(Organisation organisation) {
        organisations.remove(organisation);
    }

    // -----Konferencer----- //
    public static void addKonference(Konference konference) {
        konferencer.add(konference);
    }

    public static ArrayList<Konference> getKonferencer() {
        return new ArrayList<>(konferencer);
    }

    public static void removeKonference(Konference konference) {
        konferencer.remove(konference);
    }

    // ---------------------------------------------------------------------------------------------------
    // init content

    public static void initContent() {
        Organisation odense = Service.createOrganisation("Odense Universitet");
        Konference havOgHimmel = Service.createKonference(odense, LocalDate.of(2018, 05, 18),
                LocalDate.of(2018, 05, 21), "Odense Universitet", "Hav og Himmel", "Miljø", 1500);
        Konference hyggeligheden = Service.createKonference(odense, LocalDate.of(2018, 04, 30),
                LocalDate.of(2018, 05, 10), "Smilets By", "Hyggeligheden", "Godt humør", 115);
    }
}