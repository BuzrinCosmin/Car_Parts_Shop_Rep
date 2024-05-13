package org.example.service;

import org.example.repository.ClientRepository;
import org.hibernate.Session;

import java.util.List;

public class ShowClientOffers {
  public static void execute(Session session) {
    ClientRepository clientRepository = new ClientRepository(session);
    List<Client> clientList= findAll();
    Map<Integer, Client> map = new HashMap<>();
    int i = 0;
    for (Client client :clientList ) {
      map.put(++i, client);
      System.out.printf("%5d. %s\n", i, client.toString());
    }
    System.out.print("Choose client by current number: ");
    Client client= map.get(Integer.parseInt(UserConsole.get().getScanner().nextLine()));
    System.out.print("======   Client [" + client + "] ");
    if (client.getOffers().isEmpty()) {
      System.out.println("has no offer.");
      return;
    }
    System.out.println("offer(s):");
    client.getOffers().forEach(System.out.println);
    System.out.println("======   end [" + client.getName() + "] offer(s)");


  }
}
