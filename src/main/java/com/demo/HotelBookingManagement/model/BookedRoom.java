package com.demo.HotelBookingManagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookedRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookingId;
    @Column(name = "check_In")
    private LocalDate checkInDate;
    @Column(name = "check_Out")
    private LocalDate checkOutDate;
    @Column(name = "guest_FullName")
    private String guestFullName;
    @Column(name = "guest_Email")
    private String guestEmail;
    @Column(name = "adults")
    private int numOfAdults;
    @Column(name = "children")
    private int numOfChildren;
    @Column(name = "total_guest")
    private int totalNumberOfGuest;
    @Column(name = "confirmation_code")
    private String bookingConfirmationCode;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;
    public void calculateTotalNumberOfGuest(){
        this.totalNumberOfGuest = this.numOfAdults+this.numOfChildren;
    }

    public void setNumOfAdults(int numOfAdults) {
        this.numOfAdults = numOfAdults;
        calculateTotalNumberOfGuest();
    }

    public void setNumOfChildren(int numOfChildren) {
        this.numOfChildren = numOfChildren;
        calculateTotalNumberOfGuest();
    }

}
