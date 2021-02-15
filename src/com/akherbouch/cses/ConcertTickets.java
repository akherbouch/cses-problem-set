package com.akherbouch.cses;

import com.akherbouch.cses.utils.Algo2;
import com.akherbouch.cses.utils.FastScanner;
import com.akherbouch.cses.utils.IntegerPair;

import java.io.PrintWriter;
import java.util.*;

public class ConcertTickets {

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] h = new int[n];
        int[] pos = new int[n];
        for (int i = 0; i<n; i++) {
            h[i] = in.nextInt();
            pos[i] = i;
        }
        Algo2.shuffleAndSort(h);
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i<m; i++) {
            int ti = in.nextInt();
            int p = Algo2.floor(h , ti);
            while (p != -1 && pos[p] != p) {
                int tmp = pos[p];
                if (tmp != -1) pos[p] = pos[tmp];
                p = tmp;
            }
            if (p != -1) {
                buf.append(h[p]).append("\n");
                pos[p]--;
            } else {
                buf.append(-1).append("\n");
            }
        }
        out.println(buf.toString());
    }

    public void solve1(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        TreeMap<Integer, Integer> tickets = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int ticket = in.nextInt();
            int old = tickets.getOrDefault(ticket, 0);
            tickets.put(ticket, old + 1);
        }

        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int ti = in.nextInt();
            Map.Entry<Integer, Integer> ticket = tickets.floorEntry(ti);
            if (ticket == null) {
                buf.append(-1).append("\n");
                continue;
            }
            if (ticket.getValue() == 1) tickets.remove(ticket.getKey());
            else tickets.put(ticket.getKey(), ticket.getValue() - 1);
            buf.append(ticket.getKey()).append("\n");
        }
        out.println(buf.toString());
    }

    public void solve2(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        TreeSet<IntegerPair> tickets = new TreeSet<>();
        for(int i = 0; i<n; i++) {
            int ticketPrice = in.nextInt();
            tickets.add(new IntegerPair(ticketPrice, i));
        }
        StringBuilder buf = new StringBuilder();
        for(int i = 0; i<m; i++) {
            int ti = in.nextInt();
            IntegerPair ticket = tickets.floor(new IntegerPair(ti, n));
            if (ticket != null) {
                buf.append(ticket.first()).append("\n");
                tickets.remove(ticket);
            } else buf.append(-1).append("\n");
        }
        out.println(buf.toString());
    }

}
