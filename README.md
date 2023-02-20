# DiscogsUserStatistics

This repository contains tools for generating statistics from the activity and collection of a [discogs](http://discogs.com) user.

For an example see the profile page of user [killerblau](https://www.discogs.com/user/killerblau).


## Collection Statistics

As a discogs user you can add releases from the discogs library to your virtual
collection. 

The output of the statistics is mostly ready to be pasted into your profile, e.g. it uses the markdown.

### Favourite Artists

### Favourite Labels

### Favourite Countries

### Favourite Genre

### Favourite Styles

### Favourite Formats

### Distribution over Years

Do you want to see if you have been stuck in the 70s with your collection or rather
have continuously grown it over the last decades?

```
[b]Year distribution[/b] (19.02.2023)
01) 1982: 1
01) 1983: 1
03) 1984: 2
04) 1985: 6
05) 1986: 7
06) 1987: 8
07) 1988: 15
08) 1989: 38
09) 1990: 54
10) 1991: 72
11) 1992: 63
12) 1993: 68
13) 1994: 112
14) 1995: 103
15) 1996: 135
16) 1997: 144
17) 1998: 152
18) 1999: 151
19) 2000: 135
19) 2001: 135
21) 2002: 158
22) 2003: 145
23) 2004: 151
23) 2005: 151
25) 2006: 168
25) 2007: 168
27) 2008: 171
28) 2009: 176
29) 2010: 215
30) 2011: 205
31) 2012: 218
32) 2013: 227
33) 2014: 177
34) 2015: 154
35) 2016: 143
36) 2017: 38
37) 2018: 8
38) 2019: 11
39) 2020: 9
40) 2021: 13
41) 2022: 2
42) <Unknown>: 212

```

Note that some releases don't have information about their year.

## Activity Statistics

As a discogs user you can add releases to the library that are yet missing. Other
users can then add these releases to the collection when they own a copy, or they
can add them to their wantlist if they plan to get hold of a copy in the future.

### Most Owned Submissions

If you want to see how popular submissions have become check this statistic.

### Most Wanted Submissions

Ever wondered how rare but popular your submissions are? This statistic is for you.

## Compare Collections and Wantlists

Set any amount of users want- and have-lists to compare what all lists have they
in common. Useful to see what a buyer also wants and you as a seller
have in your collection.


## Behind the Scenes

This library consume the [discogs API](https://www.discogs.com/developers) without any
other tool involved. Not all endpoints are implemented.