package org.example.service;

import org.example.repository.CarPartRepository;
import org.example.repository.CarRepository;
import org.example.repository.ClientRepository;
import org.example.repository.OfferRepository;
import org.hibernate.Session;

import java.util.List;

public class MakeOffer {
  public static void execute(Session session) {
    Offer offer = new offer();

    ClientRepository clientRepository = new ClientRepository(session);
    List<Client> clientList = findAll();
    Map<Integer, Client> map = new HashMap<>();
    int i = 0;
    for (Client client : clientList) {
      map.put(++i, client);
      System.out.printf("%5d. %s\n", i, client.toString());
    }
    System.out.print("Choose client by current number: ");
    Client client = map.get(Integer.parseInt(UserConsole.get().getScanner().nextLine()));

    CarPartRepository carPartRepository = new CarPartRepository(session);
    List<CarPart> carParts = carPartRepository.findAll();
    Map<Integer, CarPart> carPartHashMap = new HashMap<>();
    i = 0;
    for (CarPart carPart : new CarPartRepository(session).findAll()) {
      carPartMap.put(++i, carPart);
      System.out.printf("%5d. %s\n", i, carPart.toString());
    }
    System.out.print("Choose car parts by ',' separated list of current numbers: ");
    Arrays.stream(UserConsole.get().getScanner().nextLine().replaceAll("\\s", "").split(","))
            .map(Integer::parseInt).map(carPartMap::get).toList();

    Double totalAmount = carPartsList.stream().map(CarPart::getPrice).reduce(.0, Double::sum);
    System.out.printf("Total amount: $%.2f\n", OfferUtility.getTotalAmount(carParts));

    System.out.print("Set the offer by amount or by discount ? ( $ / [%] ): ");
    boolean byAmount = UserConsole.get().getScanner().nextLine().trim().equals("$");
// choose amount/discount with respect to previous action
    System.out.print("Set " + (byAmount ? "amount ( $ )" : "discount ( % )") + ": ");
    Double tmp = Double.parseDouble(UserConsole.get().getScanner().nextLine());
    if (!byAmount) {
      tmp = totalAmount * (1 - (tmp / 100));
    }
    offer.setAmount(tmp);
    offer.getCarParts().addAll(carPartList);
    OfferRepository offerRepository = new OfferRepository(session);
    offerRepository.insert(offer, client);

    System.out.println("Client: " + client);
    System.out.println(offer);
// choose to submit, modify or abort
    System.out.print("Submit, Modify, Abort ? ( S / [M] / A ): ");
    String answer = UserConsole.get().getScanner().nextLine().trim();
    if ("A".equalsIgnoreCase(answer)) {
      break;
    }
    if ("S".equalsIgnoreCase(answer)) {
      new OfferRepository(session).insert(offer, client);
      break;
    }
    offer.getCarParts().clear();

  }
}
