package org.oryxel.viabedrockpack;

import com.google.gson.JsonParser;
import net.minecraft.util.Identifier;
import org.oryxel.viabedrockpack.pluginmessage.BedrockMessageHandler;
import org.oryxel.viabedrockpack.pluginmessage.data.CustomEntityData;

public class Test {
    public static final String TEST_GEO = "{\n" +
            "\t\"format_version\": \"1.12.0\",\n" +
            "\t\"minecraft:geometry\": [\n" +
            "\t\t{\n" +
            "\t\t\t\"description\": {\n" +
            "\t\t\t\t\"identifier\": \"geometry.cubecraft.npc.eggwars.mega\",\n" +
            "\t\t\t\t\"texture_width\": 128,\n" +
            "\t\t\t\t\"texture_height\": 128,\n" +
            "\t\t\t\t\"visible_bounds_width\": 3,\n" +
            "\t\t\t\t\"visible_bounds_height\": 4.5,\n" +
            "\t\t\t\t\"visible_bounds_offset\": [0, 1.75, 0]\n" +
            "\t\t\t},\n" +
            "\t\t\t\"bones\": [\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"name\": \"head\",\n" +
            "\t\t\t\t\t\"pivot\": [-1, 28.03125, -7.8375],\n" +
            "\t\t\t\t\t\"rotation\": [10, 0, -10],\n" +
            "\t\t\t\t\t\"cubes\": [\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [-4.69655, 21.57408, -12.36926],\n" +
            "\t\t\t\t\t\t\t\"size\": [8, 8, 8],\n" +
            "\t\t\t\t\t\t\t\"pivot\": [-2, 28.02542, -7.70404],\n" +
            "\t\t\t\t\t\t\t\"rotation\": [9.84153, 3.0315, 2.45868],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"north\": {\"uv\": [34.1, 8.1], \"uv_size\": [7.8, 7.8]},\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [26.1, 8.1], \"uv_size\": [7.8, 7.8]},\n" +
            "\t\t\t\t\t\t\t\t\"south\": {\"uv\": [50.1, 8.1], \"uv_size\": [7.8, 7.8]},\n" +
            "\t\t\t\t\t\t\t\t\"west\": {\"uv\": [42.1, 8.1], \"uv_size\": [7.8, 7.8]},\n" +
            "\t\t\t\t\t\t\t\t\"up\": {\"uv\": [34.1, 0.1], \"uv_size\": [7.8, 7.8]},\n" +
            "\t\t\t\t\t\t\t\t\"down\": {\"uv\": [42.1, 7.9], \"uv_size\": [7.8, -7.8]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [-6.69655, 26.5175, -14.27748],\n" +
            "\t\t\t\t\t\t\t\"size\": [12, 1, 12],\n" +
            "\t\t\t\t\t\t\t\"inflate\": 0.2,\n" +
            "\t\t\t\t\t\t\t\"pivot\": [-2, 28.02542, -7.70404],\n" +
            "\t\t\t\t\t\t\t\"rotation\": [4.84153, 3.0315, 2.45868],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"north\": {\"uv\": [12.1, 37.1], \"uv_size\": [11.8, 0.8]},\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [0.1, 37.1], \"uv_size\": [11.8, 0.8]},\n" +
            "\t\t\t\t\t\t\t\t\"south\": {\"uv\": [36.1, 37.1], \"uv_size\": [11.8, 0.8]},\n" +
            "\t\t\t\t\t\t\t\t\"west\": {\"uv\": [24.1, 37.1], \"uv_size\": [11.8, 0.8]},\n" +
            "\t\t\t\t\t\t\t\t\"up\": {\"uv\": [12.1, 25.1], \"uv_size\": [11.8, 11.8]},\n" +
            "\t\t\t\t\t\t\t\t\"down\": {\"uv\": [24.1, 36.9], \"uv_size\": [11.8, -11.8]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [-4.69655, 27.89571, -12.52653],\n" +
            "\t\t\t\t\t\t\t\"size\": [8, 2, 8],\n" +
            "\t\t\t\t\t\t\t\"inflate\": 0.2,\n" +
            "\t\t\t\t\t\t\t\"pivot\": [-2, 28.02542, -7.70404],\n" +
            "\t\t\t\t\t\t\t\"rotation\": [4.84153, 3.0315, 2.45868],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"north\": {\"uv\": [8.1, 46.1], \"uv_size\": [7.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [0.1, 46.1], \"uv_size\": [7.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"south\": {\"uv\": [24.1, 46.1], \"uv_size\": [7.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"west\": {\"uv\": [16.1, 46.1], \"uv_size\": [7.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"up\": {\"uv\": [44.1, 25.1], \"uv_size\": [7.8, 7.8]},\n" +
            "\t\t\t\t\t\t\t\t\"down\": {\"uv\": [16.1, 45.9], \"uv_size\": [7.8, -7.8]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t]\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"name\": \"body\",\n" +
            "\t\t\t\t\t\"pivot\": [0, 18.90909, -4.94091],\n" +
            "\t\t\t\t\t\"rotation\": [40, 0, 0],\n" +
            "\t\t\t\t\t\"cubes\": [\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [-4, 10.5, -6.25],\n" +
            "\t\t\t\t\t\t\t\"size\": [8, 12, 4],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"north\": {\"uv\": [4.1, 4.1], \"uv_size\": [7.8, 11.8]},\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [0.1, 4.1], \"uv_size\": [3.8, 11.8]},\n" +
            "\t\t\t\t\t\t\t\t\"south\": {\"uv\": [16.1, 4.1], \"uv_size\": [7.8, 11.8]},\n" +
            "\t\t\t\t\t\t\t\t\"west\": {\"uv\": [12.1, 4.1], \"uv_size\": [3.8, 11.8]},\n" +
            "\t\t\t\t\t\t\t\t\"up\": {\"uv\": [4.1, 0.1], \"uv_size\": [7.8, 3.8]},\n" +
            "\t\t\t\t\t\t\t\t\"down\": {\"uv\": [12.1, 3.9], \"uv_size\": [7.8, -3.8]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [-4, 9.5, -6.25],\n" +
            "\t\t\t\t\t\t\t\"size\": [8, 10, 4],\n" +
            "\t\t\t\t\t\t\t\"inflate\": 0.3,\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"north\": {\"uv\": [36.1, 42.1], \"uv_size\": [7.8, 9.8]},\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [32.1, 42.1], \"uv_size\": [3.8, 9.8]},\n" +
            "\t\t\t\t\t\t\t\t\"south\": {\"uv\": [48.1, 42.1], \"uv_size\": [7.8, 9.8]},\n" +
            "\t\t\t\t\t\t\t\t\"west\": {\"uv\": [44.1, 42.1], \"uv_size\": [3.8, 9.8]},\n" +
            "\t\t\t\t\t\t\t\t\"up\": {\"uv\": [36.1, 38.1], \"uv_size\": [7.8, 3.8]},\n" +
            "\t\t\t\t\t\t\t\t\"down\": {\"uv\": [44.1, 41.9], \"uv_size\": [7.8, -3.8]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t]\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"name\": \"leftArm\",\n" +
            "\t\t\t\t\t\"pivot\": [-5, 22, -5],\n" +
            "\t\t\t\t\t\"rotation\": [-45, -35, 55],\n" +
            "\t\t\t\t\t\"cubes\": [\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [-20.66383, 34.02459, -12.9637],\n" +
            "\t\t\t\t\t\t\t\"size\": [9, 3, 9],\n" +
            "\t\t\t\t\t\t\t\"pivot\": [-15.97065, 36.08312, -11.45923],\n" +
            "\t\t\t\t\t\t\t\"rotation\": [14.59589, -75.82269, -72.67394],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"north\": {\"uv\": [49.1, 86.1], \"uv_size\": [8.8, 2.8]},\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [40.1, 86.1], \"uv_size\": [8.8, 2.8]},\n" +
            "\t\t\t\t\t\t\t\t\"south\": {\"uv\": [67.1, 86.1], \"uv_size\": [8.8, 2.8]},\n" +
            "\t\t\t\t\t\t\t\t\"west\": {\"uv\": [58.1, 86.1], \"uv_size\": [8.8, 2.8]},\n" +
            "\t\t\t\t\t\t\t\t\"up\": {\"uv\": [49.1, 77.1], \"uv_size\": [8.8, 8.8]},\n" +
            "\t\t\t\t\t\t\t\t\"down\": {\"uv\": [58.1, 85.9], \"uv_size\": [8.8, -8.8]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [-21.26383, 30.52459, -13.3637],\n" +
            "\t\t\t\t\t\t\t\"size\": [10, 4, 10],\n" +
            "\t\t\t\t\t\t\t\"pivot\": [-15.97065, 36.08312, -11.45923],\n" +
            "\t\t\t\t\t\t\t\"rotation\": [14.59589, -75.82269, -72.67394],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"north\": {\"uv\": [10.1, 98.1], \"uv_size\": [9.8, 3.8]},\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [0.1, 98.1], \"uv_size\": [9.8, 3.8]},\n" +
            "\t\t\t\t\t\t\t\t\"south\": {\"uv\": [30.1, 98.1], \"uv_size\": [9.8, 3.8]},\n" +
            "\t\t\t\t\t\t\t\t\"west\": {\"uv\": [20.1, 98.1], \"uv_size\": [9.8, 3.8]},\n" +
            "\t\t\t\t\t\t\t\t\"up\": {\"uv\": [10.1, 88.1], \"uv_size\": [9.8, 9.8]},\n" +
            "\t\t\t\t\t\t\t\t\"down\": {\"uv\": [20.1, 97.9], \"uv_size\": [9.8, -9.8]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [-19.66383, 27.52459, -11.9637],\n" +
            "\t\t\t\t\t\t\t\"size\": [7, 1, 7],\n" +
            "\t\t\t\t\t\t\t\"pivot\": [-15.97065, 36.08312, -11.45923],\n" +
            "\t\t\t\t\t\t\t\"rotation\": [14.59589, -75.82269, -72.67394],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"north\": {\"uv\": [7.1, 83.1], \"uv_size\": [6.8, 0.8]},\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [0.1, 83.1], \"uv_size\": [6.8, 0.8]},\n" +
            "\t\t\t\t\t\t\t\t\"south\": {\"uv\": [21.1, 83.1], \"uv_size\": [6.8, 0.8]},\n" +
            "\t\t\t\t\t\t\t\t\"west\": {\"uv\": [14.1, 83.1], \"uv_size\": [6.8, 0.8]},\n" +
            "\t\t\t\t\t\t\t\t\"up\": {\"uv\": [7.1, 76.1], \"uv_size\": [6.8, 6.8]},\n" +
            "\t\t\t\t\t\t\t\t\"down\": {\"uv\": [14.1, 82.9], \"uv_size\": [6.8, -6.8]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [-20.66383, 28.52459, -12.9637],\n" +
            "\t\t\t\t\t\t\t\"size\": [9, 2, 9],\n" +
            "\t\t\t\t\t\t\t\"pivot\": [-15.97065, 36.08312, -11.45923],\n" +
            "\t\t\t\t\t\t\t\"rotation\": [14.59589, -75.82269, -72.67394],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"north\": {\"uv\": [9.1, 85.1], \"uv_size\": [8.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [0.1, 85.1], \"uv_size\": [8.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"south\": {\"uv\": [27.1, 85.1], \"uv_size\": [8.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"west\": {\"uv\": [18.1, 85.1], \"uv_size\": [8.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"up\": {\"uv\": [9.1, 76.1], \"uv_size\": [8.8, 8.8]},\n" +
            "\t\t\t\t\t\t\t\t\"down\": {\"uv\": [18.1, 84.9], \"uv_size\": [8.8, -8.8]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [-19.66383, 36.32459, -11.9637],\n" +
            "\t\t\t\t\t\t\t\"size\": [7, 2, 7],\n" +
            "\t\t\t\t\t\t\t\"pivot\": [-15.97065, 36.08312, -11.45923],\n" +
            "\t\t\t\t\t\t\t\"rotation\": [14.59589, -75.82269, -72.67394],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"north\": {\"uv\": [54.1, 98.1], \"uv_size\": [6.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [47.1, 98.1], \"uv_size\": [6.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"south\": {\"uv\": [68.1, 98.1], \"uv_size\": [6.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"west\": {\"uv\": [61.1, 98.1], \"uv_size\": [6.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"up\": {\"uv\": [54.1, 91.1], \"uv_size\": [6.8, 6.8]},\n" +
            "\t\t\t\t\t\t\t\t\"down\": {\"uv\": [61.1, 97.9], \"uv_size\": [6.8, -6.8]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [-19.16383, 37.32459, -11.4637],\n" +
            "\t\t\t\t\t\t\t\"size\": [6, 2, 6],\n" +
            "\t\t\t\t\t\t\t\"pivot\": [-15.97065, 36.08312, -11.45923],\n" +
            "\t\t\t\t\t\t\t\"rotation\": [14.59589, -75.82269, -72.67394],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"north\": {\"uv\": [87.1, 96.1], \"uv_size\": [5.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [81.1, 96.1], \"uv_size\": [5.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"south\": {\"uv\": [99.1, 96.1], \"uv_size\": [5.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"west\": {\"uv\": [93.1, 96.1], \"uv_size\": [5.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"up\": {\"uv\": [87.1, 90.1], \"uv_size\": [5.8, 5.8]},\n" +
            "\t\t\t\t\t\t\t\t\"down\": {\"uv\": [93.1, 95.9], \"uv_size\": [5.8, -5.8]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [-17.66383, 39.02459, -9.9637],\n" +
            "\t\t\t\t\t\t\t\"size\": [3, 1, 3],\n" +
            "\t\t\t\t\t\t\t\"pivot\": [-15.97065, 36.08312, -11.45923],\n" +
            "\t\t\t\t\t\t\t\"rotation\": [14.59589, -75.82269, -72.67394],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"north\": {\"uv\": [83.1, 83.1], \"uv_size\": [2.8, 0.8]},\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [80.1, 83.1], \"uv_size\": [2.8, 0.8]},\n" +
            "\t\t\t\t\t\t\t\t\"south\": {\"uv\": [89.1, 83.1], \"uv_size\": [2.8, 0.8]},\n" +
            "\t\t\t\t\t\t\t\t\"west\": {\"uv\": [86.1, 83.1], \"uv_size\": [2.8, 0.8]},\n" +
            "\t\t\t\t\t\t\t\t\"up\": {\"uv\": [83.1, 80.1], \"uv_size\": [2.8, 2.8]},\n" +
            "\t\t\t\t\t\t\t\t\"down\": {\"uv\": [86.1, 82.9], \"uv_size\": [2.8, -2.8]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [-12.76383, 35.72459, -10.4637],\n" +
            "\t\t\t\t\t\t\t\"size\": [1, 2, 4],\n" +
            "\t\t\t\t\t\t\t\"pivot\": [-15.97065, 36.08312, -11.45923],\n" +
            "\t\t\t\t\t\t\t\"rotation\": [14.59589, -75.82269, -72.67394],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"north\": {\"uv\": [54.1, 104.1], \"uv_size\": [0.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [50.1, 104.1], \"uv_size\": [3.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"south\": {\"uv\": [59.1, 104.1], \"uv_size\": [0.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"west\": {\"uv\": [55.1, 104.1], \"uv_size\": [3.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"up\": {\"uv\": [54.1, 100.1], \"uv_size\": [0.8, 3.8]},\n" +
            "\t\t\t\t\t\t\t\t\"down\": {\"uv\": [55.1, 103.9], \"uv_size\": [0.8, -3.8]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [-13.76383, 36.72459, -10.4637],\n" +
            "\t\t\t\t\t\t\t\"size\": [1, 2, 4],\n" +
            "\t\t\t\t\t\t\t\"pivot\": [-15.97065, 36.08312, -11.45923],\n" +
            "\t\t\t\t\t\t\t\"rotation\": [14.59589, -75.82269, -72.67394],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"north\": {\"uv\": [54.1, 104.1], \"uv_size\": [0.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [50.1, 104.1], \"uv_size\": [3.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"south\": {\"uv\": [59.1, 104.1], \"uv_size\": [0.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"west\": {\"uv\": [55.1, 104.1], \"uv_size\": [3.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"up\": {\"uv\": [54.1, 100.1], \"uv_size\": [0.8, 3.8]},\n" +
            "\t\t\t\t\t\t\t\t\"down\": {\"uv\": [55.1, 103.9], \"uv_size\": [0.8, -3.8]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [-19.56383, 36.72459, -10.4637],\n" +
            "\t\t\t\t\t\t\t\"size\": [1, 2, 4],\n" +
            "\t\t\t\t\t\t\t\"pivot\": [-15.97065, 36.08312, -11.45923],\n" +
            "\t\t\t\t\t\t\t\"rotation\": [14.59589, -75.82269, -72.67394],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"north\": {\"uv\": [54.1, 104.1], \"uv_size\": [0.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [50.1, 104.1], \"uv_size\": [3.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"south\": {\"uv\": [59.1, 104.1], \"uv_size\": [0.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"west\": {\"uv\": [55.1, 104.1], \"uv_size\": [3.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"up\": {\"uv\": [54.1, 100.1], \"uv_size\": [0.8, 3.8]},\n" +
            "\t\t\t\t\t\t\t\t\"down\": {\"uv\": [55.1, 103.9], \"uv_size\": [0.8, -3.8]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [-20.56383, 35.72459, -10.4637],\n" +
            "\t\t\t\t\t\t\t\"size\": [1, 2, 4],\n" +
            "\t\t\t\t\t\t\t\"pivot\": [-15.97065, 36.08312, -11.45923],\n" +
            "\t\t\t\t\t\t\t\"rotation\": [14.59589, -75.82269, -72.67394],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"north\": {\"uv\": [54.1, 104.1], \"uv_size\": [0.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [50.1, 104.1], \"uv_size\": [3.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"south\": {\"uv\": [59.1, 104.1], \"uv_size\": [0.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"west\": {\"uv\": [55.1, 104.1], \"uv_size\": [3.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"up\": {\"uv\": [54.1, 100.1], \"uv_size\": [0.8, 3.8]},\n" +
            "\t\t\t\t\t\t\t\t\"down\": {\"uv\": [55.1, 103.9], \"uv_size\": [0.8, -3.8]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [-9.72512, 35.72459, -13.31606],\n" +
            "\t\t\t\t\t\t\t\"size\": [1, 2, 4],\n" +
            "\t\t\t\t\t\t\t\"pivot\": [-15.97065, 36.08312, -11.45923],\n" +
            "\t\t\t\t\t\t\t\"rotation\": [176.35749, -13.71067, 122.36001],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"north\": {\"uv\": [54.1, 104.1], \"uv_size\": [0.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [50.1, 104.1], \"uv_size\": [3.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"south\": {\"uv\": [59.1, 104.1], \"uv_size\": [0.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"west\": {\"uv\": [55.1, 104.1], \"uv_size\": [3.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"up\": {\"uv\": [54.1, 100.1], \"uv_size\": [0.8, 3.8]},\n" +
            "\t\t\t\t\t\t\t\t\"down\": {\"uv\": [55.1, 103.9], \"uv_size\": [0.8, -3.8]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [-10.52512, 36.72459, -13.31606],\n" +
            "\t\t\t\t\t\t\t\"size\": [1, 2, 4],\n" +
            "\t\t\t\t\t\t\t\"pivot\": [-15.97065, 36.08312, -11.45923],\n" +
            "\t\t\t\t\t\t\t\"rotation\": [176.35749, -13.71067, 122.36001],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"north\": {\"uv\": [54.1, 104.1], \"uv_size\": [0.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [50.1, 104.1], \"uv_size\": [3.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"south\": {\"uv\": [59.1, 104.1], \"uv_size\": [0.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"west\": {\"uv\": [55.1, 104.1], \"uv_size\": [3.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"up\": {\"uv\": [54.1, 100.1], \"uv_size\": [0.8, 3.8]},\n" +
            "\t\t\t\t\t\t\t\t\"down\": {\"uv\": [55.1, 103.9], \"uv_size\": [0.8, -3.8]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [-16.42512, 36.72459, -13.31606],\n" +
            "\t\t\t\t\t\t\t\"size\": [1, 2, 4],\n" +
            "\t\t\t\t\t\t\t\"pivot\": [-15.97065, 36.08312, -11.45923],\n" +
            "\t\t\t\t\t\t\t\"rotation\": [176.35749, -13.71067, 122.36001],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"north\": {\"uv\": [54.1, 104.1], \"uv_size\": [0.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [50.1, 104.1], \"uv_size\": [3.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"south\": {\"uv\": [59.1, 104.1], \"uv_size\": [0.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"west\": {\"uv\": [55.1, 104.1], \"uv_size\": [3.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"up\": {\"uv\": [54.1, 100.1], \"uv_size\": [0.8, 3.8]},\n" +
            "\t\t\t\t\t\t\t\t\"down\": {\"uv\": [55.1, 103.9], \"uv_size\": [0.8, -3.8]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [-17.42512, 35.72459, -13.31606],\n" +
            "\t\t\t\t\t\t\t\"size\": [1, 2, 4],\n" +
            "\t\t\t\t\t\t\t\"pivot\": [-15.97065, 36.08312, -11.45923],\n" +
            "\t\t\t\t\t\t\t\"rotation\": [176.35749, -13.71067, 122.36001],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"north\": {\"uv\": [54.1, 104.1], \"uv_size\": [0.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [50.1, 104.1], \"uv_size\": [3.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"south\": {\"uv\": [59.1, 104.1], \"uv_size\": [0.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"west\": {\"uv\": [55.1, 104.1], \"uv_size\": [3.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"up\": {\"uv\": [54.1, 100.1], \"uv_size\": [0.8, 3.8]},\n" +
            "\t\t\t\t\t\t\t\t\"down\": {\"uv\": [55.1, 103.9], \"uv_size\": [0.8, -3.8]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [-13.26016, 23.25448, -6.25289],\n" +
            "\t\t\t\t\t\t\t\"size\": [4, 7, 4],\n" +
            "\t\t\t\t\t\t\t\"inflate\": -0.1,\n" +
            "\t\t\t\t\t\t\t\"pivot\": [-11.25999, 26.25409, -3.99794],\n" +
            "\t\t\t\t\t\t\t\"rotation\": [-22.41156, 32.16705, 123.90866],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"north\": {\"uv\": [20.1, 64.1], \"uv_size\": [3.8, 5.8]},\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [16.1, 64.1], \"uv_size\": [3.8, 5.8]},\n" +
            "\t\t\t\t\t\t\t\t\"south\": {\"uv\": [28.1, 64.1], \"uv_size\": [3.8, 5.8]},\n" +
            "\t\t\t\t\t\t\t\t\"west\": {\"uv\": [24.1, 64.1], \"uv_size\": [3.8, 5.8]},\n" +
            "\t\t\t\t\t\t\t\t\"up\": {\"uv\": [20.1, 60.1], \"uv_size\": [3.8, 3.8]},\n" +
            "\t\t\t\t\t\t\t\t\"down\": {\"uv\": [24.1, 63.9], \"uv_size\": [3.8, -3.8]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [-9.31286, 20.1743, -5.71952],\n" +
            "\t\t\t\t\t\t\t\"size\": [4, 7, 4],\n" +
            "\t\t\t\t\t\t\t\"inflate\": 0.2,\n" +
            "\t\t\t\t\t\t\t\"pivot\": [-7.08257, 22.7054, -3.116],\n" +
            "\t\t\t\t\t\t\t\"rotation\": [10.22784, 31.78823, 124.10661],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"north\": {\"uv\": [44.1, 61.1], \"uv_size\": [3.8, 5.8]},\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [40.1, 61.1], \"uv_size\": [3.8, 5.8]},\n" +
            "\t\t\t\t\t\t\t\t\"south\": {\"uv\": [52.1, 61.1], \"uv_size\": [3.8, 5.8]},\n" +
            "\t\t\t\t\t\t\t\t\"west\": {\"uv\": [48.1, 61.1], \"uv_size\": [3.8, 5.8]},\n" +
            "\t\t\t\t\t\t\t\t\"up\": {\"uv\": [44.1, 57.1], \"uv_size\": [3.8, 3.8]},\n" +
            "\t\t\t\t\t\t\t\t\"down\": {\"uv\": [48.1, 60.9], \"uv_size\": [3.8, -3.8]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t]\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"name\": \"rightArm\",\n" +
            "\t\t\t\t\t\"pivot\": [7.60159, 23.63454, -6.6706],\n" +
            "\t\t\t\t\t\"rotation\": [-75, -40, -65],\n" +
            "\t\t\t\t\t\"cubes\": [\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [5.71182, 16.91966, -9.56587],\n" +
            "\t\t\t\t\t\t\t\"size\": [4, 6, 4],\n" +
            "\t\t\t\t\t\t\t\"inflate\": -0.1,\n" +
            "\t\t\t\t\t\t\t\"pivot\": [7.76429, 24.44101, -8.30375],\n" +
            "\t\t\t\t\t\t\t\"rotation\": [-50.70622, -10.31667, -38.17296],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"north\": {\"uv\": [60.1, 61.1], \"uv_size\": [3.8, 5.8]},\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [56.1, 61.1], \"uv_size\": [3.8, 5.8]},\n" +
            "\t\t\t\t\t\t\t\t\"south\": {\"uv\": [68.1, 61.1], \"uv_size\": [3.8, 5.8]},\n" +
            "\t\t\t\t\t\t\t\t\"west\": {\"uv\": [64.1, 61.1], \"uv_size\": [3.8, 5.8]},\n" +
            "\t\t\t\t\t\t\t\t\"up\": {\"uv\": [60.1, 57.1], \"uv_size\": [3.8, 3.8]},\n" +
            "\t\t\t\t\t\t\t\t\"down\": {\"uv\": [64.1, 60.9], \"uv_size\": [3.8, -3.8]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [6.4153, 22.77089, -10.58642],\n" +
            "\t\t\t\t\t\t\t\"size\": [4, 7, 4],\n" +
            "\t\t\t\t\t\t\t\"inflate\": 0.2,\n" +
            "\t\t\t\t\t\t\t\"pivot\": [8.48234, 24.21862, -8.72477],\n" +
            "\t\t\t\t\t\t\t\"rotation\": [-37.60718, -8.82447, -35.54597],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"north\": {\"uv\": [60.1, 41.1], \"uv_size\": [3.8, 5.8]},\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [56.1, 41.1], \"uv_size\": [3.8, 5.8]},\n" +
            "\t\t\t\t\t\t\t\t\"south\": {\"uv\": [68.1, 41.1], \"uv_size\": [3.8, 5.8]},\n" +
            "\t\t\t\t\t\t\t\t\"west\": {\"uv\": [64.1, 41.1], \"uv_size\": [3.8, 5.8]},\n" +
            "\t\t\t\t\t\t\t\t\"up\": {\"uv\": [60.1, 37.1], \"uv_size\": [3.8, 3.8]},\n" +
            "\t\t\t\t\t\t\t\t\"down\": {\"uv\": [64.1, 40.9], \"uv_size\": [3.8, -3.8]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t]\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"name\": \"leftLeg\",\n" +
            "\t\t\t\t\t\"pivot\": [-1.9, 11, 0.2],\n" +
            "\t\t\t\t\t\"rotation\": [0, 10, 0],\n" +
            "\t\t\t\t\t\"cubes\": [\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [-5.13838, 0.55519, -0.95206],\n" +
            "\t\t\t\t\t\t\t\"size\": [4.1, 3, 4],\n" +
            "\t\t\t\t\t\t\t\"inflate\": 0.2,\n" +
            "\t\t\t\t\t\t\t\"pivot\": [-1.97499, 3.06019, 0.28947],\n" +
            "\t\t\t\t\t\t\t\"rotation\": [9.89628, -0.49128, 4.76821],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"north\": {\"uv\": [70.1, 12.1], \"uv_size\": [3.8, 2.8]},\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [66.1, 12.1], \"uv_size\": [3.8, 2.8]},\n" +
            "\t\t\t\t\t\t\t\t\"south\": {\"uv\": [78.1, 12.1], \"uv_size\": [3.8, 2.8]},\n" +
            "\t\t\t\t\t\t\t\t\"west\": {\"uv\": [74.1, 12.1], \"uv_size\": [3.8, 2.8]},\n" +
            "\t\t\t\t\t\t\t\t\"up\": {\"uv\": [70.1, 8.1], \"uv_size\": [3.8, 3.8]},\n" +
            "\t\t\t\t\t\t\t\t\"down\": {\"uv\": [74.1, 11.9], \"uv_size\": [3.8, -3.8]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [-5.13103, 0.64434, -2.84969],\n" +
            "\t\t\t\t\t\t\t\"size\": [4, 2, 1],\n" +
            "\t\t\t\t\t\t\t\"inflate\": 0.2,\n" +
            "\t\t\t\t\t\t\t\"pivot\": [-1.82749, 4.12512, -0.62547],\n" +
            "\t\t\t\t\t\t\t\"rotation\": [29.89628, -0.49128, 4.76821],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"north\": {\"uv\": [25.1, 39.1], \"uv_size\": [3.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [24.1, 39.1], \"uv_size\": [0.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"south\": {\"uv\": [30.1, 39.1], \"uv_size\": [3.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"west\": {\"uv\": [29.1, 39.1], \"uv_size\": [0.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"up\": {\"uv\": [25.1, 38.1], \"uv_size\": [3.8, 0.8]},\n" +
            "\t\t\t\t\t\t\t\t\"down\": {\"uv\": [29.1, 38.9], \"uv_size\": [3.8, -0.8]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [-4.907, 3.68484, -1.04026],\n" +
            "\t\t\t\t\t\t\t\"size\": [4, 8, 4],\n" +
            "\t\t\t\t\t\t\t\"inflate\": 0.15,\n" +
            "\t\t\t\t\t\t\t\"pivot\": [-1.72135, 4.42594, 1.6398],\n" +
            "\t\t\t\t\t\t\t\"rotation\": [0, 0, 5],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"north\": {\"uv\": [6.1, 105.1], \"uv_size\": [3.8, 8.8]},\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [2.1, 105.1], \"uv_size\": [3.8, 8.8]},\n" +
            "\t\t\t\t\t\t\t\t\"south\": {\"uv\": [14.1, 105.1], \"uv_size\": [3.8, 8.8]},\n" +
            "\t\t\t\t\t\t\t\t\"west\": {\"uv\": [10.1, 105.1], \"uv_size\": [3.8, 8.8]},\n" +
            "\t\t\t\t\t\t\t\t\"up\": {\"uv\": [4.1, 56.1], \"uv_size\": [3.8, 3.8]},\n" +
            "\t\t\t\t\t\t\t\t\"down\": {\"uv\": [8.1, 59.9], \"uv_size\": [3.8, -3.8]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t]\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"name\": \"rightLeg\",\n" +
            "\t\t\t\t\t\"pivot\": [1.9, 11.25, -0.8],\n" +
            "\t\t\t\t\t\"rotation\": [-10, -10, -5],\n" +
            "\t\t\t\t\t\"cubes\": [\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [1.46072, -0.89822, -1.19818],\n" +
            "\t\t\t\t\t\t\t\"size\": [4, 4, 4],\n" +
            "\t\t\t\t\t\t\t\"inflate\": 0.2,\n" +
            "\t\t\t\t\t\t\t\"pivot\": [1.92104, 1.76712, -0.58123],\n" +
            "\t\t\t\t\t\t\t\"rotation\": [15, -40, -5],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"north\": {\"uv\": [4.1, 71.1], \"uv_size\": [3.8, 3.8]},\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [0.1, 71.1], \"uv_size\": [3.8, 3.8]},\n" +
            "\t\t\t\t\t\t\t\t\"south\": {\"uv\": [12.1, 71.1], \"uv_size\": [3.8, 3.8]},\n" +
            "\t\t\t\t\t\t\t\t\"west\": {\"uv\": [8.1, 71.1], \"uv_size\": [3.8, 3.8]},\n" +
            "\t\t\t\t\t\t\t\t\"up\": {\"uv\": [4.1, 67.1], \"uv_size\": [3.8, 3.8]},\n" +
            "\t\t\t\t\t\t\t\t\"down\": {\"uv\": [8.1, 70.9], \"uv_size\": [3.8, -3.8]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [1.46072, -0.89822, -2.59818],\n" +
            "\t\t\t\t\t\t\t\"size\": [4, 2, 1],\n" +
            "\t\t\t\t\t\t\t\"inflate\": 0.2,\n" +
            "\t\t\t\t\t\t\t\"pivot\": [1.92104, 1.76712, -0.58123],\n" +
            "\t\t\t\t\t\t\t\"rotation\": [15, -40, -5],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"north\": {\"uv\": [59.1, 9.1], \"uv_size\": [3.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [58.1, 9.1], \"uv_size\": [0.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"south\": {\"uv\": [64.1, 9.1], \"uv_size\": [3.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"west\": {\"uv\": [63.1, 9.1], \"uv_size\": [0.8, 1.8]},\n" +
            "\t\t\t\t\t\t\t\t\"up\": {\"uv\": [59.1, 8.1], \"uv_size\": [3.8, 0.8]},\n" +
            "\t\t\t\t\t\t\t\t\"down\": {\"uv\": [63.1, 8.9], \"uv_size\": [3.8, -0.8]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [1.4098, 3.14159, -1.73435],\n" +
            "\t\t\t\t\t\t\t\"size\": [3.8, 8, 4],\n" +
            "\t\t\t\t\t\t\t\"inflate\": 0.15,\n" +
            "\t\t\t\t\t\t\t\"pivot\": [1.59878, 1.92172, -0.55364],\n" +
            "\t\t\t\t\t\t\t\"rotation\": [0, -40, -5],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"north\": {\"uv\": [9.9, 105.1], \"uv_size\": [-3.8, 8.8]},\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [5.9, 105.1], \"uv_size\": [-3.8, 8.8]},\n" +
            "\t\t\t\t\t\t\t\t\"south\": {\"uv\": [17.9, 105.1], \"uv_size\": [-3.8, 8.8]},\n" +
            "\t\t\t\t\t\t\t\t\"west\": {\"uv\": [13.9, 105.1], \"uv_size\": [-3.8, 8.8]},\n" +
            "\t\t\t\t\t\t\t\t\"up\": {\"uv\": [58.1, 12.1], \"uv_size\": [2.8, 3.8]},\n" +
            "\t\t\t\t\t\t\t\t\"down\": {\"uv\": [61.1, 15.9], \"uv_size\": [2.8, -3.8]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t]\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t{\n" +
            "\t\t\t\t\t\"name\": \"partyhat\",\n" +
            "\t\t\t\t\t\"pivot\": [-1.98631, 45.9799, -9.4325],\n" +
            "\t\t\t\t\t\"rotation\": [-165.79403, -80.53475, 163.03891],\n" +
            "\t\t\t\t\t\"cubes\": [\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [-4.99022, 41.73131, -11.72828],\n" +
            "\t\t\t\t\t\t\t\"size\": [6, 2, 6],\n" +
            "\t\t\t\t\t\t\t\"pivot\": [-5.73475, 47.42949, -7.41962],\n" +
            "\t\t\t\t\t\t\t\"rotation\": [5.01502, 13.2014, -6.04222],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"north\": {\"uv\": [120, 45], \"uv_size\": [6, 2]},\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [120, 45], \"uv_size\": [6, 2]},\n" +
            "\t\t\t\t\t\t\t\t\"south\": {\"uv\": [120, 45], \"uv_size\": [6, 2]},\n" +
            "\t\t\t\t\t\t\t\t\"west\": {\"uv\": [120, 45], \"uv_size\": [6, 2]},\n" +
            "\t\t\t\t\t\t\t\t\"up\": {\"uv\": [120, 40], \"uv_size\": [6, 6]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [-2.64486, 44.64118, -10.72828],\n" +
            "\t\t\t\t\t\t\t\"size\": [0, 9, 4],\n" +
            "\t\t\t\t\t\t\t\"pivot\": [-5.73475, 47.42949, -7.41962],\n" +
            "\t\t\t\t\t\t\t\"rotation\": [9.71404, 10.27784, 16.75279],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [110, 29], \"uv_size\": [8, 18]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [-4.93429, 43.69287, -5.6329],\n" +
            "\t\t\t\t\t\t\t\"size\": [0, 5, 4],\n" +
            "\t\t\t\t\t\t\t\"pivot\": [-5.73475, 47.42949, -7.41962],\n" +
            "\t\t\t\t\t\t\t\"rotation\": [116.91945, 59.70644, 107.63153],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [110, 37], \"uv_size\": [8, 10]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [-9.58574, 41.76617, -7.94703],\n" +
            "\t\t\t\t\t\t\t\"size\": [0, 5, 4],\n" +
            "\t\t\t\t\t\t\t\"pivot\": [-5.73475, 47.42949, -7.41962],\n" +
            "\t\t\t\t\t\t\t\"rotation\": [179.5607, -11.78706, 150.81468],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [110, 37], \"uv_size\": [8, 10]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t},\n" +
            "\t\t\t\t\t\t{\n" +
            "\t\t\t\t\t\t\t\"origin\": [-7.50383, 42.62852, -13.14565],\n" +
            "\t\t\t\t\t\t\t\"size\": [0, 5, 4],\n" +
            "\t\t\t\t\t\t\t\"pivot\": [-5.73475, 47.42949, -7.41962],\n" +
            "\t\t\t\t\t\t\t\"rotation\": [-57.8738, -69.54395, 53.26548],\n" +
            "\t\t\t\t\t\t\t\"uv\": {\n" +
            "\t\t\t\t\t\t\t\t\"east\": {\"uv\": [110, 37], \"uv_size\": [8, 10]}\n" +
            "\t\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t]\n" +
            "\t\t\t\t}\n" +
            "\t\t\t]\n" +
            "\t\t}\n" +
            "\t]\n" +
            "}";

    public static void test() {
        final CustomEntityData data = new CustomEntityData("test", 0, Identifier.of(ViaBedrockPack.MOD_ID, "test/eggwars.mega.texture.png"), JsonParser.parseString(TEST_GEO).getAsJsonObject());
        new BedrockMessageHandler().handle(data);
    }
}
