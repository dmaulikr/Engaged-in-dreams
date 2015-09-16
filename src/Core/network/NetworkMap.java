
        package Core.network;

        import java.io.BufferedReader;

        import java.io.FileReader;
        import java.io.IOException;

public class NetworkMap {
    private char map[][];

    public char[][] createMap (int SizeX,int SizeY){
        map = new char[SizeX][SizeY];
        for (int i = 0; i < map[0].length; i++) {
            for (int j = 0; j < map.length; j++) {
                   map[i][j] = '0';
            }
        }
        return map;
    }

    public char[][] createMap(String fileName) throws IOException {
        String str = new String();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append("\n");
                    line = br.readLine();
                }
                str = sb.toString();
            } finally {
                br.close();
            }


            int temp;
            int i = 0;
            int j = 0;
            int lenth = str.indexOf("\n");

            for (temp = 0; temp < str.length(); temp++) {
                i = (int) str.charAt(temp);
                if (i == 10) {
                    j++;
                }
            }

            map = new char[lenth][j + 1];
            j = 0;
            int a = 0;
            for (temp = 0; temp < str.length(); temp++) {
                i = (int) str.charAt(temp);
                if ((i >= 47) && (i <= 57) || (i == 32)) {
                    map[a][j] = (char) i;
                    a++;
                } else {
                    if (i == 10) {
                        j++;
                        a = 0;
                    }
                }
            }
            // Output
            System.out.println("Map recognised: ");
            for (i = 0; i < map[0].length; i++) {
                for (j = 0; j < map.length; j++) {
                    System.out.print(map[j][i]);
                }
                System.out.println();
            }
        } catch (Exception e) {System.out.println("Map recognising error!"); return null;}
        return map;
    }

    public char getNeuron(int PosX, int PosY) {
        char n;
        try {
            n = map[PosX][PosY];
        }
        catch (Exception e) {
            n = 'E';             //will return 'E' - empty
        }
        return n;
    }

    public char getNextNeuron(int PosX, int PosY, int way) {
        char n = 0;
        try {
            if (way==1)
                n = map[PosX-1][PosY];
            if (way==2)
                n = map[PosX][PosY-1];
            if (way==3)
                n = map[PosX+1][PosY];
            if (way==4)
                n = map[PosX][PosY+1];
        }
        catch (Exception e) {
            n = 'E';             //will return 'E' - empty
        }
        return n;
    }

    public int[] getSosed(int PosX, int PosY) {
        int[] ways =  new int[5];
        for (int i = 1; i <= 4; i++) {
            try {
                char n = getNextNeuron(PosX,PosY,i);
                if (((int)n >= 47) && ((int)n <= 57)) {
                    ways[i]=i;
                }
                else {
                    ways[i]=0;
                }
            }
            catch (Exception e) {
                ways[i]=0;
            }
        }
        return ways;                //Will return int[5] = {0, wayLeft = 0/1, wayUp = 0/2, wayRight = 0/3, wayDown = 0/4
    }

}