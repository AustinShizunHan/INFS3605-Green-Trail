package com.example.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private List<Plant> plants;
    private EditText searchBar;
    private Button sortButton;
    private boolean ascendingOrder = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plants = new ArrayList<>();
        plants.add(new Plant("Hill's Fig", R.drawable.abc, "The ultimate lush tree, Hill's Fig can also be grown as a large hedge or pruned for topiary. In low rainfall areas, it has the perfect shape to provide dense shade.", "Hill's Fig is a large, evergreen tree that can grow up to 25 meters tall. It has a broad, spreading canopy and dense foliage that provides shade and shelter for a variety of wildlife. The leaves are glossy and dark green, with a smooth texture and pointed tips. The tree produces small, round fruit that are edible but not usually eaten by humans.\n" +
                "\n" +
                " "));
        plants.add(new Plant("Gymea Lilly", R.drawable.b, "Gymea Lily is a large, dramatic plant that is native to the coastal regions of New South Wales in Australia.", "The Gymea Lily can grow up to 4 meters tall and produces a tall, spear-like inflorescence that can reach up to 6 meters in height. The inflorescence is covered in hundreds of bright red flowers that attract birds and other wildlife. The leaves are strap-like and can grow up to 2 meters long, forming a large rosette at the base of the plant.\n" +
                "\n" +
                " "));
        plants.add(new Plant("Broad-leaved Paperbark", R.drawable.c, "Broad-leaved Paperbark (Melaleuca quinquenervia) is a species of paperbark tree that is native to eastern Australia, from Queensland to Victoria.", "The Broad-leaved Paperbark can grow up to 20 meters tall and has a distinctive, papery bark that peels away in strips. The leaves are long and narrow, with five distinct veins running parallel to the midrib. The tree produces clusters of small, white flowers that are highly attractive to bees and other pollinators.\n" +
                "\n" +
                " "));
        plants.add(new Plant("Crimson Bottlerush", R.drawable.d, "The Crimson Bottlebrush (Callistemon citrinus) is a species of bottlebrush plant that is native to eastern Australia, from Queensland to Victoria.", "The Crimson Bottlebrush can grow up to 5 meters tall and has striking, cylindrical flower spikes that are bright red in color. The leaves are narrow and lance-shaped, with a lemon-like fragrance when crushed. The tree produces small, woody fruits that contain numerous small seeds.\n" +
                "\n" +
                " "));
        plants.add(new Plant("Heath Banksia", R.drawable.e, "Banksia ericifolia, the heath-leaved banksia, or lantern banksia, is a species of woody shrub of the family Proteaceae native to Australia. It grows in two separate regions of Central and Northern New South Wales east of the Great Dividing Range.", "Banksia ericifolia grows as a large shrub up to 6 metres (20 feet) in height, though often smaller, around 1–2 metres (3.5–6.5 ft), in exposed places such as coastal or mountain heathlands. The grey-coloured bark is smooth and fairly thin with lenticels; however it can thicken significantly with age. "));
        plants.add(new Plant("Mountain Cedar Wattle", R.drawable.f, "Acacia elata the cedar wattle or mountain cedar wattle is a tree found in eastern Australia.", "The tree can grow to a height of around 20 m (66 ft) when mature, with exceptional specimens reaching over 30 m (98 ft). It has deeply fissured bark with a dark brown to black colour at the base of the tree with terete branchlets that are hairy when young. The dark green evergreen leaves typically have a length of 2.5 to 9 cm (0.98 to 3.54 in) with one prominent gland about halfway along. "));
        plants.add(new Plant("Native Mint", R.drawable.g, "Native Mint (Mentha australis) is a species of mint plant that is native to Australia. It is a member of the Lamiaceae family and is also known as River Mint, Wild Mint or Australian Mint..", "The Native Mint can grow up to 1 meter tall and has oval-shaped leaves with a strong minty fragrance. The flowers are small and white or purple in color, and are arranged in clusters at the end of the stems. The plant produces small, round seeds that are dispersed by wind or water.\n" +
                "\n" +
                "The Native Mint is an important plant in many ecosystems, providing food and habitat for a variety of wildlife.  "));
        plants.add(new Plant("Tuckeroo", R.drawable.h, "Australian native feature tree with a rounded shape, broad shady canopy, and evergreen rounded foliage. Cream flowers appear during autumn followed by bright orange fruit in spring..", "Growing up to 10 metres (33 ft) with a stem diameter of 50 centimetres (20 in). The bark is smooth grey or brown with raised horizontal lines. The bases of the trees are usually flanged.\n" +
                "\n" +
                "Leaves are pinnate and alternate with six to ten leaflets. These are not toothed, and are egg-shaped to elliptic-oblong, and 7 to 10 centimetres (2.8 to 3.9 in) long. The tips are often notched or blunt.  \n" +
                "\n" +
                "\n" +
                "\n" +
                ""));
        plants.add(new Plant("Prickly Leaved Tea Tree", R.drawable.i, "Leptospermum continentale, commonly known as prickly tea-tree, is a species of slender, straggling shrub that is endemic to south-eastern Australia. It has sharp-pointed, narrowly egg-shaped leaves, white flowers arranged singly in leaf axils and woody fruit that remains on the plant when mature.", "Leptospermum continentale is a slender, straggling shrub that typically grows to a height of 1–2 m (3 ft 3 in – 6 ft 7 in) or more. It has smooth bark that is shed in stringy strips. The leaves are narrow egg-shaped, 5–13 mm (0.20–0.51 in) long and 1–3.5 mm (0.039–0.138 in) wide with a sharp point on the end. "));
        plants.add(new Plant("Water Vine", R.drawable.j, "Cissus hypoglauca is a common Australian vine. It is one of the better known climbing plants of the genus Cissus in the grape family. A very common climber in moist areas of eastern Australia, it often colonises large areas after forest damage due to storms, fire or logging. Common names include jungle grape, water vine, giant water vine, five-leaf water vine, jungle vine, native grapes and billangai.", "Cissus hypoglauca is a large woody vine. The name water-vine comes from the fact that the woody sections of the vine may be cut into sections and the sap that drips from the sections may be drunk as water. The leaves are palmate, and are usually arranged in a group of five. Leaves elliptic or ovate in shape, slightly toothed or entire. Mid green above and a glaucous shade underneath, and measure 3 to 15 cm (1–6 in) long, 1.5 to 4 cm (0.6-1.6 in) wide. \n" +
                "\n" +
                ""));
        plants.add(new Plant("Rock Lily", R.drawable.k, "Rock Lily (Dendrobium speciosum) is a species of orchid that is native to eastern Australia, from Queensland to Victoria. It is a member of the Orchidaceae family and is also known as the Sydney Rock Orchid or King Orchid.", "The Rock Lily can grow up to 1 meter tall and has large, showy flowers that are usually white or pale pink in color, with a yellow or orange center. The flowers are arranged in clusters at the end of the stems, and the plant produces long, thin leaves that are usually green in color.\n" +
                "\n" +
                "The Rock Lily is an important plant in many ecosystems, providing habitat for a variety of wildlife. "));
        plants.add(new Plant("Sandpaper Fig", R.drawable.l, "icus coronata, commonly known as the sandpaper fig or creek sandpaper fig, is a species of fig tree, native to Australia. It is found along the east coast from Mackay in Central Queensland, through New South Wales and just into Victoria near Mallacoota. It grows along river banks and gullies in rainforest and open forest. Its common name is derived from its rough sandpapery leaves, which it shares with the other sandpaper figs.", "The sandpaper fig is a small tree which may reach the dimensions of 6–12 m (20–39 ft) tall by 3–5 m (9.8–16.4 ft) wide, although is generally smaller. The trunk is dark brown, and the ovate or elliptical leaves are 5–15 cm (2.0–5.9 in) long by 2–5 cm (0.79–1.97 in) wide and very scabrous (rough) like sandpaper on the upper side. The new growth is hairy. The succulent oval fruit is around 1.5 cm (0.59 in) long and covered in dense hairs"));
        plants.add(new Plant("Burrawang", R.drawable.m, "Burrawang (Macrozamia communis) is a species of cycad that is native to eastern Australia, from southern Queensland to Victoria. It is a member of the Zamiaceae family and is also known as the Burrawang Palm or Grass Tree.", "The Burrawang can grow up to 10 meters tall and has a distinctive, palm-like appearance, with a trunk covered in rough, bark-like scales and a crown of long, feathery fronds. The plant produces large, cone-shaped fruits that contain highly toxic seeds.\n" +
                "\n" +
                "The Burrawang is an important plant in many ecosystems, providing food and habitat for a variety of wildlife. "));
        plants.add(new Plant("Plum Pine", R.drawable.n, "Podocarpus elatus, known as the plum pine, the brown pine or the Illawarra plum, is a species of Podocarpus endemic to the east coast of Australia, in eastern New South Wales and eastern Queensland.\n" +
                "\n" +
                "", "It is a medium to large evergreen tree growing to 30–36 m tall with a trunk up to 1.5 m diameter. The leaves are lanceolate, 5–15 cm long (to 25 cm long on vigorous young trees) and 6–18 mm broad. The seed cones are dark blue-purple, berry-like, with a fleshy base 2-2.5 cm diameter bearing a single oval or globose seed 1 cm in diameter."));
        plants.add(new Plant("Tussock Grass", R.drawable.o, "Tussock Grass (Poa labillardieri) is a species of grass that is native to southeastern Australia, including Tasmania, Victoria, and New South Wales. It is a member of the Poaceae family and is also known as Common Tussock Grass or Five-day Grass..", "Tussock Grass can grow up to 1.5 meters tall and has a distinctive tussock or clumping growth habit, with long, narrow leaves that are blue-green in color. The plant produces seed heads in late spring or early summer, which contain numerous small seeds.\n" +
                "\n" +
                "Tussock Grass is an important plant in many ecosystems, providing habitat and food for a variety of wildlife. "));
        plants.add(new Plant("Cabbage Tree Palm", R.drawable.p, "Livistona australis, the cabbage-tree palm, is an Australian plant species in the family Arecaceae. It is a tall, slender palm growing up to about 25 m in height and 0.35 m diameter.", "It is crowned with dark, glossy green leaves on petioles 2 m long. It has leaves plaited like a fan; the cabbage of these is small but sweet. In summer it bears flower spikes with sprigs of cream-white flowers. The trees accumulate dead fronds or leaves, which when the plant is in cultivation are often removed by an arborist.\n" +
                "\n" +
                ""));
        plants.add(new Plant("Bolwarra", R.drawable.q, "Bolwarra (Eupomatia laurina) is a species of small tree or shrub that is native to eastern Australia, from southern Queensland to eastern Victoria. It is a member of the Eupomatiaceae family and is also known as Bolwarra Plum or Native Guava.", "Bolwarra can grow up to 10 meters tall and has dark green, glossy leaves that are oval or lance-shaped. The plant produces small, greenish-yellow flowers that are highly fragrant and followed by red or purple, edible fruit that is sweet and aromatic.\n" +
                "\n" +
                "Bolwarra is an important plant in many ecosystems, providing food and habitat for a variety of wildlife. "));
        plants.add(new Plant("Blue Flax Lily", R.drawable.r, "Blue Flax Lily (Dianella caerulea) is a species of flowering plant that is native to Australia. It is a member of the Asphodelaceae family and is also known as Paroo Lily, Tasman Flax Lily, or Blueberry Lily..", "Blue Flax Lily can grow up to 1 meter tall and has long, narrow leaves that are blue-green in color. The plant produces clusters of small, star-shaped flowers that are blue or purple in color, followed by small, blue or black berries that are edible but not widely consumed.\n" +
                "\n" +
                "Blue Flax Lily is an important plant in many ecosystems, providing food and habitat for a variety of wildlife. "));
        plants.add(new Plant("Old man banksia", R.drawable.s, "Banksia serrata, commonly known as the saw banksia, the old man banksia,[3] the saw-tooth banksia or the red honeysuckle and as wiriyagan by the Cadigal people, is a species of woody shrub or tree of the genus Banksia, in the family Proteaceae. ", "Banksia serrata usually grows as a gnarled and misshapen tree up to 16 m (50 ft) tall, although in some coastal habitats it grows as a shrub of 1–3 m (3–10 ft), and on exposed coastal cliffs it has even been recorded as a prostrate shrub. As a tree it usually has a single, stout trunk with warty, knobbly grey bark up to 3 cm (1.2 in) thick. Trunks are often black from past bushfires, and ooze a red sap when injured. "));
        plants.add(new Plant("Matrush", R.drawable.t, "Matrush (Lomandra longifolia) is a species of perennial, tufted plant that is native to eastern Australia, from Queensland to Victoria. It is a member of the Asparagaceae family and is also known as Spiny-headed Matrush or Basket Grass.", "Matrush can grow up to 1.5 meters tall and has long, narrow leaves that are dark green and strap-like in shape. The plant produces small, yellowish-green flowers that are arranged in dense clusters, followed by small, brownish-black berries.\n" +
                "\n" +
                "Matrush is an important plant in many ecosystems, providing habitat and food for a variety of wildlife. "));
        plants.add(new Plant("Ribery", R.drawable.u, "Riberry (Syzygium luehmannii) is a species of small to medium-sized tree that is native to eastern Australia, from Queensland to New South Wales. It is a member of the Myrtaceae family and is also known as Small-leaved Lilli Pilli or Cherry Satinash..", "Riberry can grow up to 15 meters tall and has dark green, glossy leaves that are oval or lance-shaped. The plant produces small, white or creamy-yellow flowers that are highly fragrant, followed by edible, bright red fruit that is sweet and tangy, with a texture similar to a cranberry.\n" +
                "\n" +
                "Riberry is an important plant in many ecosystems, providing food and habitat for a variety of wildlife. "));
        plants.add(new Plant("Grass Tree", R.drawable.v, "Xanthorrhoea (/zænθoʊˈriːə/) is a genus of about 30 species of flowering plants endemic to Australia. Species are known by the name grass tree.", "All are perennials and have a secondary thickening meristem in the stem. Many, but not all, species develop an above ground stem. The stem may take up to twenty years to emerge. Plants begin as a crown of rigid grass-like leaves, the caudex slowly growing beneath. The main stem or branches continue to develop beneath the crown, This is rough-surfaced, built from accumulated leaf-bases around the secondarily thickened trunk. \n" +
                "\n" +
                "\n" +
                "\n" +
                ""));
        plants.add(new Plant("Native Ginger", R.drawable.w, "Alpinia caerulea, commonly known as native ginger or in the case of the subspecies from the Atherton Tableland red back ginger, is an understorey perennial herb to 3 m, growing under rainforest, gallery forest and wet sclerophyll forest canopy in eastern Australia.", "Native Ginger is an important plant in many ecosystems, providing food and habitat for a variety of wildlife. It is also highly valued for its ornamental, culinary, and medicinal uses. The fruit can be used in jams, chutneys, and sauces, and the leaves and roots have traditional medicinal uses in some Aboriginal cultures. Native Ginger is a popular plant in gardens and public spaces due to its attractive appearance, hardiness, and versatility. "));
        plants.add(new Plant("Flame Tree", R.drawable.x, "Brachychiton acerifolius is a large tree of the family Malvaceae endemic to tropical and subtropical regions on the east coast of Australia. ", "This species is a large deciduous tree which forms a pyramidal habit. It may reach 30 to 35 m (98 to 115 ft) in height in its natural habitat, but is usually shorter in cultivation. The trunk is smoothly cylindrical and green or grey-green in colour, often tapering unbranched to the very tip of the tree. Leaves have long petioles and measure up to 30 cm (12 in) x 25 cm (9.8 in), are glossy green, glabrous, simple, alternate, and highly variable in shape \n" +
                "\n" +
                ""));
        plants.add(new Plant("Port Jackson Fig", R.drawable.y, "Ficus rubiginosa, the rusty fig or Port Jackson fig (damun in the Dharug language), is a species of flowering plant native to eastern Australia in the genus Ficus.", "A spreading, densely-shading tree when mature, F. rubiginosa may reach 30 m (100 ft) or more in height, although it rarely exceeds 10 m (30 ft) in the Sydney region. The trunk is buttressed and can reach 1.5 m (4 ft 11 in) in diameter. The bark is yellow-brown. It can also grow as on other plants as a hemiepiphyte, or 1–5 m (3–16 ft) high lithophyte. \n" +
                "\n" +
                "It closely resembles its relative, the Moreton Bay fig (F. macrophylla). Having similar ranges in the wild, they are often confused. The smaller leaves, shorter fruit stalks, and rusty colour of the undersides of the leaves of F. rubiginosa are the easiest distinguishing features. It is also confused with the small-leaved fig (F. obliqua), the syconia of which are smaller, measuring 4–12 mm long and 4–11 mm in diameter, compared with 7–17 mm long and 8–17 mm diameter for F. rubiginosa."));
        recyclerView = findViewById(R.id.plants_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(plants, this);
        recyclerView.setAdapter(adapter);

        searchBar = findViewById(R.id.search_bar);
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });


            }

    }





