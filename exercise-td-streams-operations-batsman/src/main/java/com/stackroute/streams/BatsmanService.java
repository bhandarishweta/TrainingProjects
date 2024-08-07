package com.stackroute.streams;

import java.util.*;
import java.util.stream.Collectors;

public class BatsmanService {
    public Optional<Batsman> getBatsman(List<Batsman> batsmanList, String batsmanName, String countryCode) {
        if (batsmanList == null || batsmanName == null || batsmanName.isEmpty() || countryCode == null || countryCode.isEmpty()) {
            return Optional.empty();
        }

        boolean countryExists = batsmanList.stream()
                .anyMatch(batsman -> batsman.getCountry().getCountryCode().equalsIgnoreCase(countryCode));

        if (!countryExists) {
            throw new CountryNotFoundException("Country with code " + countryCode + " not found");
        }

        return batsmanList.stream()
                .filter(batsman -> batsman.getName().equalsIgnoreCase(batsmanName) &&
                        batsman.getCountry().getCountryCode().equalsIgnoreCase(countryCode))
                .findFirst();
    }


    public Map<String,Integer> getPlayerNameWithTotalRuns(List<Batsman> batsmanList){
        if (batsmanList == null || batsmanList.isEmpty()) {
            return Collections.emptyMap();
        }
        return batsmanList.stream().collect(Collectors.toMap(Batsman::getName, Batsman::getTotalRuns));
    }

    public Integer getHighestRunsScoredByBatsman(List<Batsman> batsmanList, String countryName){
        if (batsmanList == null || batsmanList.isEmpty() || countryName == null || countryName.isEmpty()) {
            return 0;
        }
        Optional<Integer> highestScore = batsmanList.stream().filter(b->b.getCountry().getName().equalsIgnoreCase(countryName))
                .map(Batsman::getHighestScore).max(Integer::compare);

        return highestScore.orElse(0);
    }
    public Optional<List<String>> getPlayerNamesByCountry(List<Batsman> batsmanList, String countryName){
        if (batsmanList == null || batsmanList.isEmpty() || countryName == null || countryName.isEmpty()) {
            return Optional.empty();
        }
       List<String> playerNames = batsmanList.stream().filter(b -> b.getCountry().getName().equalsIgnoreCase(countryName))
                       .filter(b->b.getTotalRuns()>5000)
               .map(Batsman::getName).sorted(Collections.reverseOrder()).collect(Collectors.toCollection(LinkedList::new));
        if (playerNames.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(playerNames);

    }
    public String getBatsmanNamesForCountry(List<Batsman> batsmanList, String countryCode) {
        if (batsmanList == null || batsmanList.isEmpty() || countryCode == null || countryCode.isEmpty()) {
            return null;
        }
        return batsmanList.stream().filter(b ->b.getCountry().getCountryCode().equalsIgnoreCase(countryCode))
                .map(Batsman::getName)
                .sorted().toList().toString().replace(" ", "");
    }

}

