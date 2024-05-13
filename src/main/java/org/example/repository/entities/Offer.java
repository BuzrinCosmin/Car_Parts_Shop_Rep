package org.example.repository.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity(name = "offers")
public class Offer {
  @Id
  @GeneratedValue
  private UUID id;
  @NonNull
  private Double amount;
  @ManyToMany
  @JoinTable(
    name = "car_parts_to_offers",
    joinColumns = @JoinColumn(name = "offer_id"),
    inverseJoinColumns = @JoinColumn(name = "car_part_id")
  )
  private final List<CarPart> carParts = new ArrayList<>();

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder("Offer {");
    result.append((null == id) ? "not yet an offer" : id.toString()).append("}:\n");
    carParts.forEach(carPart -> result.append("    ").append(carPart.toString()).append("\n"));
    DecimalFormat decimalFormat = new DecimalFormat("0.00");
    return result
            .append("  total amount: $").append(decimalFormat.format(OfferUtility.getTotalAmount(carParts)))
            .append("  amount: $").append(decimalFormat.format(amount))
            .append("  discount: ").append(decimalFormat.format(OfferUtility.getDiscount(this))).append(" %")
            .toString();
  }

}
