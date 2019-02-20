package de.jmizv.discogsuserstatistics;

import de.jmizv.discogsuserstatistics.stat.AbstractAggregatedStatistic;
import de.jmizv.discogsuserstatistics.stat.AbstractScalarStatistic;
import de.jmizv.discogsuserstatistics.stat.AbstractStatistic;
import de.jmizv.discogsuserstatistics.stat.FavouriteFormatsStatistic;
import de.jmizv.discogsuserstatistics.stat.FavouriteStyleStatistic;
import de.jmizv.discogsuserstatistics.stat.FavouriteCountriesStatistic;
import de.jmizv.discogsuserstatistics.stat.YearStatistic;
import de.jmizv.discogsuserstatistics.stat.FavouriteArtistStatistic;
import de.jmizv.discogsuserstatistics.stat.FavouriteLabelStatistic;
import de.jmizv.discogsuserstatistics.stat.FavouriteGenreStatistic;
import de.jmizv.discogsuserstatistics.stat.MostPossessedInCollectionStatistic;
import de.jmizv.discogsuserstatistics.stat.MostWantedInCollectionStatistic;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import javafx.util.Pair;

public class Main {

    public static void main(String[] args) throws Exception {
        DiscogsCache cache = new DiscogsCache();
        List<AbstractAggregatedStatistic> aggregatedStats = new ArrayList<>();
        aggregatedStats.add(new FavouriteArtistStatistic());
//        aggregatedStats.add(new YearStatistic());
//        aggregatedStats.add(new FavouriteLabelStatistic());
//        aggregatedStats.add(new FavouriteGenreStatistic());
//        aggregatedStats.add(new FavouriteStyleStatistic());
//        aggregatedStats.add(new FavouriteCountriesStatistic(false));
//        aggregatedStats.add(new FavouriteFormatsStatistic(false));
//        aggregatedStats.add(new FavouriteFormatsStatistic(true));

        List<AbstractScalarStatistic> scalarStats = new ArrayList<>();
        scalarStats.add(new MostPossessedInCollectionStatistic());
        scalarStats.add(new MostWantedInCollectionStatistic());

        String username = args.length > 0 ? args[0] : "killerblau";
        username = "Hallunke";
//        username = "guru_mosh";
//        username = "RikWal";
//        username = "rudeboyheiko";
        String[] usernames = new String[]{"bassline_k", "zengogott", "Krangk23", "elliexv", "diegoldenehor.de", "decloe", "chris2403", "13meterohnekopf", "kresswessendorf", "luxcs5000", "Twinky79", "chewbaccaismyfriend",};
        usernames = new String[]{username};
        for (String un : usernames) {
            username = un;
            for (AbstractAggregatedStatistic stat : aggregatedStats) {
                System.out.println("Start " + stat.getClass().getSimpleName() + ": " + Instant.now().toString());
                Map<String, StatisticItem> get = stat.get(username);
                List<Pair<String, StatisticItem>> list = new ArrayList<>();
                get.entrySet().forEach(p -> list.add(new Pair<>(p.getKey(), p.getValue())));
                list.sort(stat.getComparator());

                long[] cnt = {0, -1};
                try (PrintWriter pw = getPrintWriter("./" + stat.getClass().getSimpleName() + "_" + username + ".csv")) {
                    list.stream().forEach(p -> {
                        if (p.getValue().getAmount() != cnt[1]) {
                            ++cnt[0];
                            cnt[1] = p.getValue().getAmount();
                        }
                        pw.print(cnt[0]);
                        pw.print("\t");
                        pw.print(p.getValue().getAmount());
                        pw.print("\t");
                        pw.print(p.getValue().getUiText());
                        pw.print("\t");
                        pw.print(getUiText(cnt[0], p.getValue()));
                        if (p.getValue().getBbCode() != null) {
                            pw.print("\t");
                            pw.print(getBbCode(cnt[0], p.getValue()));
                        }
                        pw.print("\n");
                        pw.flush();
                    });
                    pw.print(get.size());
                    pw.print("\ttotal");
                }

            }
            for (AbstractScalarStatistic stat : scalarStats) {
                System.out.println("Start " + stat.getClass().getSimpleName() + ": " + Instant.now().toString());
                List<StatisticItem> get = stat.get(username);

                long[] cnt = {0, -1};
                try (PrintWriter pw = getPrintWriter("./" + stat.getClass().getSimpleName() + "_" + username + ".csv")) {
                    get.forEach(p -> {
                        if (p.getAmount() != cnt[1]) {
                            ++cnt[0];
                            cnt[1] = p.getAmount();
                        }
                        pw.print(cnt[0]);
                        pw.print("\t");
                        pw.print(p.getAmount());
                        pw.print("\t");
                        pw.print(p.getUiText());
                        pw.print("\t");
                        pw.print(getUiText(cnt[0], p));
                        if (p.getBbCode() != null) {
                            pw.print("\t");
                            pw.print(getBbCode(cnt[0], p));
                        }
                        pw.print("\n");
                        pw.flush();
                    });
                    pw.print(get.size());
                    pw.print("\ttotal");
                }
            }
        }
        System.out.println("Done.");
        System.out.println("Cache:\n" + cache);
    }

    public static PrintWriter getPrintWriter(String filename) throws FileNotFoundException {
        return new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File(filename)), StandardCharsets.UTF_8), true);
    }

    public static BufferedReader getBufferedReader(File filename) throws UnsupportedEncodingException, FileNotFoundException {
        return new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));
    }

    private static String getUiText(long cnt, StatisticItem item) {
        return getText(cnt, item.getUiText(), item.getAmount());
    }

    private static String getBbCode(long cnt, StatisticItem item) {
        return getText(cnt, item.getBbCode(), item.getAmount());
    }

    private static String getText(long cnt, String text, long amount) {
        return "" + cnt + ") " + text + ": " + amount;
    }

    // java -jar .. -username killerblau
}
