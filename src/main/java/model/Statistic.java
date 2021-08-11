/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class Statistic extends Product {
    private int saleNumber;
    private int revenue;

    public Statistic() {
    }

    public Statistic(int saleNumber, int revenue) {
        this.saleNumber = saleNumber;
        this.revenue = revenue;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getSaleNumber() {
        return saleNumber;
    }

    public void setSaleNumber(int saleNumber) {
        this.saleNumber = saleNumber;
    }

}
