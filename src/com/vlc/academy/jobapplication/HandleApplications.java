package com.vlc.academy.jobapplication;

import java.util.*;

public class HandleApplications {
    private Map<String, Skill> insiemeAbilita = new HashMap<>();
    private Map<String, Position> insiemePosizioniAperte = new HashMap<>();

    /**
     * Questo metodo AGGIUNGE un'abilità alla lista abilità, ma non vuole abilità duplicate
     *
     * @param names
     * @throws ApplicationException
     */
    public void addSkills(String... names) throws ApplicationException {
        for (String nome : names) {
            boolean esiste = insiemeAbilita.containsKey(nome);
            if (esiste) {
                throw new ApplicationException("Impossible inserire la skill in quanto sarebbe duplicata");
            }
            Skill skill = new Skill(nome);
            insiemeAbilita.put(nome, skill);
        }
    }

    public void addPosition(String name, String... skillNames) throws ApplicationException {
        boolean contienePosizione = insiemePosizioniAperte.containsKey(name);
        if (contienePosizione) {
            throw new ApplicationException("Posizione aperta già inserita. No duplicati");
        }
        List<Skill> skillRichieste = new ArrayList<>();

        for (String nomeSkill : skillNames) {
            Skill skill = insiemeAbilita.get(nomeSkill);
            boolean contains = insiemeAbilita.containsKey(nomeSkill);
            if (!contains || skill == null) {
                throw new ApplicationException("Abilità non contenuta o nulla, errore");
            }
            skillRichieste.add(skill);
        }// Developer -> problem solving, lavorare in team, Java, Sql,
        Position position = new Position(name);
        insiemePosizioniAperte.put(name, position); // Questo metodo tramuta un array in una lista

        for (Skill skill : skillRichieste) {
            skill.addPosition(position);  // Questo è il collegamento BIDIREZIONALE tra posizione e abilità
        }
    }

    public Skill getSkill(String name) {
        return insiemeAbilita.get(name); // Se non lo trova da null di default
    }

    public Position getPosition(String name) {
        return insiemePosizioniAperte.get(name);
    }

    public void addApplicant(String name, String capabilities) throws ApplicationException {

    }

    public String getCapabilities(String applicantName) throws ApplicationException {
        return null;
    }

    public void enterApplication(String applicantName, String positionName) throws ApplicationException {

    }

    public int setWinner(String applicantName, String positionName) throws ApplicationException {
        return 0;
    }

    public SortedMap<String, Long> skill_nApplicants() {
        return null;
    }

    public String maxPosition() {
        return null;
    }
}
