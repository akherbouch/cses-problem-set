package com.akherbouch.cses;

import com.akherbouch.cses.utils.FastScanner;
import com.akherbouch.cses.utils.IntegerPair;
import com.akherbouch.cses.utils.PrintUtil;

import java.io.PrintWriter;
import java.util.*;

public class RoomAllocation {


    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        var customers = new Customer[n];
        for (int i = 0; i<n; i++)
            customers[i] = new Customer(i , in.nextInt(), in.nextInt());
        Arrays.sort(customers);
        int[] ans = new int[n];
        var rooms = new TreeSet<IntegerPair>();
        for (int i = 0; i<n; i++) {
            Customer customer = customers[i];
            var availableRoom = rooms.lower(new IntegerPair(customer.arrival, 0));
            int roomNumber = rooms.size() + 1;
            if (availableRoom != null) {
                roomNumber = availableRoom.second();
                rooms.remove(availableRoom);
            }
            ans[customer.id] = roomNumber;
            rooms.add(new IntegerPair(customer.departure, roomNumber));
        }
        out.println(rooms.size());
        PrintUtil.printArray(out, ans);
    }


    // using a queue
    public void solve2(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        Customer[] customers = new Customer[n];
        TreeMap<Integer, Queue<Integer>> rooms = new TreeMap<>();
        for (int i = 0; i<n; i++) {
            customers[i] = new Customer(i , in.nextInt(), in.nextInt());
        }
        Arrays.sort(customers);
        int[] ans = new int[n];
        int size = 0;
        Queue<Integer> queue;
        for (Customer cus : customers) {
            int a = cus.arrival;
            Map.Entry<Integer, Queue<Integer>> lastDeparture = rooms.lowerEntry(a);
            int availableRoom =  ++size;
            if (lastDeparture != null) {
                queue = lastDeparture.getValue();
                availableRoom = queue.poll();
                --size;
                if (queue.isEmpty())
                    rooms.remove(lastDeparture.getKey());
            }
            queue = rooms.getOrDefault(cus.departure, new ArrayDeque<>());
            queue.add(availableRoom);
            rooms.put(cus.departure, queue);
            ans[cus.id] = availableRoom;
            size = Math.max(size, availableRoom);
        }
        out.println(size);
        PrintUtil.printArray(out, ans);
    }

    public static class Customer implements Comparable<Customer> {
        int id, arrival, departure;

        public Customer(int id, int arrival, int departure) {
            this.id = id;
            this.arrival = arrival;
            this.departure = departure;
        }

        @Override
        public int compareTo(Customer o) {
            if (arrival != o.arrival) return arrival - o.arrival;
            return departure - o.departure;
        }
    }
}
