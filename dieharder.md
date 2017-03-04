## KISS32Random

    #=============================================================================#
    # Testing: io.jenetics.prngine.KISS32Random (2017-03-02 22:21)                #
    #=============================================================================#
    #=============================================================================#
    # Linux 4.8.0-40-generic (amd64)                                              #
    # java version "1.8.0_112"                                                    #
    # Java(TM) SE Runtime Environment (build 1.8.0_112-b15)                       #
    # Java HotSpot(TM) 64-Bit Server VM (build 25.112-b15)                        #
    #=============================================================================#
    #=============================================================================#
    #            dieharder version 3.31.1 Copyright 2003 Robert G. Brown          #
    #=============================================================================#
    rng_name    |rands/second|   Seed   |
    stdin_input_raw|  4.36e+07  |1787614307|
    #=============================================================================#
            test_name   |ntup| tsamples |psamples|  p-value |Assessment
    #=============================================================================#
    diehard_birthdays|   0|       100|     100|0.19743180|  PASSED  
        diehard_operm5|   0|   1000000|     100|0.31113913|  PASSED  
    diehard_rank_32x32|   0|     40000|     100|0.49363112|  PASSED  
        diehard_rank_6x8|   0|    100000|     100|0.44920382|  PASSED  
    diehard_bitstream|   0|   2097152|     100|0.55809500|  PASSED  
            diehard_opso|   0|   2097152|     100|0.82617047|  PASSED  
            diehard_oqso|   0|   2097152|     100|0.75906661|  PASSED  
            diehard_dna|   0|   2097152|     100|0.65896866|  PASSED  
    diehard_count_1s_str|   0|    256000|     100|0.57216060|  PASSED  
    diehard_count_1s_byt|   0|    256000|     100|0.12592788|  PASSED  
    diehard_parking_lot|   0|     12000|     100|0.67544629|  PASSED  
        diehard_2dsphere|   2|      8000|     100|0.60361632|  PASSED  
        diehard_3dsphere|   3|      4000|     100|0.45568735|  PASSED  
        diehard_squeeze|   0|    100000|     100|0.23683576|  PASSED  
            diehard_sums|   0|       100|     100|0.38139567|  PASSED  
            diehard_runs|   0|    100000|     100|0.27276118|  PASSED  
            diehard_runs|   0|    100000|     100|0.47754770|  PASSED  
        diehard_craps|   0|    200000|     100|0.36079634|  PASSED  
        diehard_craps|   0|    200000|     100|0.49135850|  PASSED  
    marsaglia_tsang_gcd|   0|  10000000|     100|0.97161964|  PASSED  
    marsaglia_tsang_gcd|   0|  10000000|     100|0.05565807|  PASSED  
            sts_monobit|   1|    100000|     100|0.20146983|  PASSED  
                sts_runs|   2|    100000|     100|0.87802528|  PASSED  
            sts_serial|   1|    100000|     100|0.92174032|  PASSED  
            sts_serial|   2|    100000|     100|0.27314675|  PASSED  
            sts_serial|   3|    100000|     100|0.36242030|  PASSED  
            sts_serial|   3|    100000|     100|0.99102396|  PASSED  
            sts_serial|   4|    100000|     100|0.81963674|  PASSED  
            sts_serial|   4|    100000|     100|0.02986392|  PASSED  
            sts_serial|   5|    100000|     100|0.69398974|  PASSED  
            sts_serial|   5|    100000|     100|0.84969663|  PASSED  
            sts_serial|   6|    100000|     100|0.60686182|  PASSED  
            sts_serial|   6|    100000|     100|0.31395597|  PASSED  
            sts_serial|   7|    100000|     100|0.56974278|  PASSED  
            sts_serial|   7|    100000|     100|0.43563244|  PASSED  
            sts_serial|   8|    100000|     100|0.45967708|  PASSED  
            sts_serial|   8|    100000|     100|0.88397828|  PASSED  
            sts_serial|   9|    100000|     100|0.60497285|  PASSED  
            sts_serial|   9|    100000|     100|0.99792311|   WEAK   
            sts_serial|  10|    100000|     100|0.90242526|  PASSED  
            sts_serial|  10|    100000|     100|0.92871069|  PASSED  
            sts_serial|  11|    100000|     100|0.50731231|  PASSED  
            sts_serial|  11|    100000|     100|0.26131145|  PASSED  
            sts_serial|  12|    100000|     100|0.77118800|  PASSED  
            sts_serial|  12|    100000|     100|0.02368163|  PASSED  
            sts_serial|  13|    100000|     100|0.99695844|   WEAK   
            sts_serial|  13|    100000|     100|0.82651398|  PASSED  
            sts_serial|  14|    100000|     100|0.99800807|   WEAK   
            sts_serial|  14|    100000|     100|0.97447814|  PASSED  
            sts_serial|  15|    100000|     100|0.62301635|  PASSED  
            sts_serial|  15|    100000|     100|0.71216144|  PASSED  
            sts_serial|  16|    100000|     100|0.25486105|  PASSED  
            sts_serial|  16|    100000|     100|0.85642403|  PASSED  
            rgb_bitdist|   1|    100000|     100|0.54599480|  PASSED  
            rgb_bitdist|   2|    100000|     100|0.48612428|  PASSED  
            rgb_bitdist|   3|    100000|     100|0.27832396|  PASSED  
            rgb_bitdist|   4|    100000|     100|0.68653552|  PASSED  
            rgb_bitdist|   5|    100000|     100|0.40645762|  PASSED  
            rgb_bitdist|   6|    100000|     100|0.43754039|  PASSED  
            rgb_bitdist|   7|    100000|     100|0.98395080|  PASSED  
            rgb_bitdist|   8|    100000|     100|0.35702020|  PASSED  
            rgb_bitdist|   9|    100000|     100|0.21738319|  PASSED  
            rgb_bitdist|  10|    100000|     100|0.96441744|  PASSED  
            rgb_bitdist|  11|    100000|     100|0.41870314|  PASSED  
            rgb_bitdist|  12|    100000|     100|0.51012676|  PASSED  
    rgb_minimum_distance|   2|     10000|    1000|0.23262966|  PASSED  
    rgb_minimum_distance|   3|     10000|    1000|0.25386162|  PASSED  
    rgb_minimum_distance|   4|     10000|    1000|0.66573064|  PASSED  
    rgb_minimum_distance|   5|     10000|    1000|0.12919642|  PASSED  
        rgb_permutations|   2|    100000|     100|0.69349102|  PASSED  
        rgb_permutations|   3|    100000|     100|0.71708825|  PASSED  
        rgb_permutations|   4|    100000|     100|0.17279115|  PASSED  
        rgb_permutations|   5|    100000|     100|0.78291916|  PASSED  
        rgb_lagged_sum|   0|   1000000|     100|0.61540165|  PASSED  
        rgb_lagged_sum|   1|   1000000|     100|0.58121810|  PASSED  
        rgb_lagged_sum|   2|   1000000|     100|0.91099110|  PASSED  
        rgb_lagged_sum|   3|   1000000|     100|0.62233317|  PASSED  
        rgb_lagged_sum|   4|   1000000|     100|0.52974279|  PASSED  
        rgb_lagged_sum|   5|   1000000|     100|0.51039813|  PASSED  
        rgb_lagged_sum|   6|   1000000|     100|0.03474285|  PASSED  
        rgb_lagged_sum|   7|   1000000|     100|0.10035845|  PASSED  
        rgb_lagged_sum|   8|   1000000|     100|0.23720696|  PASSED  
        rgb_lagged_sum|   9|   1000000|     100|0.44492266|  PASSED  
        rgb_lagged_sum|  10|   1000000|     100|0.20289191|  PASSED  
        rgb_lagged_sum|  11|   1000000|     100|0.26335446|  PASSED  
        rgb_lagged_sum|  12|   1000000|     100|0.88028287|  PASSED  
        rgb_lagged_sum|  13|   1000000|     100|0.21464608|  PASSED  
        rgb_lagged_sum|  14|   1000000|     100|0.75025368|  PASSED  
        rgb_lagged_sum|  15|   1000000|     100|0.15405728|  PASSED  
        rgb_lagged_sum|  16|   1000000|     100|0.33489298|  PASSED  
        rgb_lagged_sum|  17|   1000000|     100|0.99852935|   WEAK   
        rgb_lagged_sum|  18|   1000000|     100|0.54735421|  PASSED  
        rgb_lagged_sum|  19|   1000000|     100|0.11488179|  PASSED  
        rgb_lagged_sum|  20|   1000000|     100|0.28269695|  PASSED  
        rgb_lagged_sum|  21|   1000000|     100|0.96020186|  PASSED  
        rgb_lagged_sum|  22|   1000000|     100|0.86203443|  PASSED  
        rgb_lagged_sum|  23|   1000000|     100|0.96576244|  PASSED  
        rgb_lagged_sum|  24|   1000000|     100|0.07864727|  PASSED  
        rgb_lagged_sum|  25|   1000000|     100|0.86313066|  PASSED  
        rgb_lagged_sum|  26|   1000000|     100|0.58997395|  PASSED  
        rgb_lagged_sum|  27|   1000000|     100|0.60301324|  PASSED  
        rgb_lagged_sum|  28|   1000000|     100|0.99748187|   WEAK   
        rgb_lagged_sum|  29|   1000000|     100|0.18197805|  PASSED  
        rgb_lagged_sum|  30|   1000000|     100|0.96261022|  PASSED  
        rgb_lagged_sum|  31|   1000000|     100|0.00040511|   WEAK   
        rgb_lagged_sum|  32|   1000000|     100|0.18199778|  PASSED  
        rgb_kstest_test|   0|     10000|    1000|0.70631976|  PASSED  
        dab_bytedistrib|   0|  51200000|       1|0.74133553|  PASSED  
                dab_dct| 256|     50000|       1|0.50267639|  PASSED  
    Preparing to run test 207.  ntuple = 0
            dab_filltree|  32|  15000000|       1|0.71655705|  PASSED  
            dab_filltree|  32|  15000000|       1|0.37440796|  PASSED  
    Preparing to run test 208.  ntuple = 0
        dab_filltree2|   0|   5000000|       1|0.83833263|  PASSED  
        dab_filltree2|   1|   5000000|       1|0.66830157|  PASSED  
    Preparing to run test 209.  ntuple = 0
            dab_monobit2|  12|  65000000|       1|0.34704650|  PASSED  
    #=============================================================================#
    # Summary: PASSED=108, WEAK=6, FAILED=0                                       #
    #          235,031.336 MB of random data created with 147.278 MB/sec          #
    #=============================================================================#
    #=============================================================================#
    # Runtime: 0:26:35                                                            #
    #=============================================================================#
    
## KISS64Random

    #=============================================================================#
    # Testing: io.jenetics.prngine.KISS64Random (2017-03-02 22:48)                #
    #=============================================================================#
    #=============================================================================#
    # Linux 4.8.0-40-generic (amd64)                                              #
    # java version "1.8.0_112"                                                    #
    # Java(TM) SE Runtime Environment (build 1.8.0_112-b15)                       #
    # Java HotSpot(TM) 64-Bit Server VM (build 25.112-b15)                        #
    #=============================================================================#
    #=============================================================================#
    #            dieharder version 3.31.1 Copyright 2003 Robert G. Brown          #
    #=============================================================================#
    rng_name    |rands/second|   Seed   |
    stdin_input_raw|  6.37e+07  |  61710760|
    #=============================================================================#
            test_name   |ntup| tsamples |psamples|  p-value |Assessment
    #=============================================================================#
    diehard_birthdays|   0|       100|     100|0.15473789|  PASSED  
        diehard_operm5|   0|   1000000|     100|0.53860322|  PASSED  
    diehard_rank_32x32|   0|     40000|     100|0.64571818|  PASSED  
        diehard_rank_6x8|   0|    100000|     100|0.99628938|   WEAK   
    diehard_bitstream|   0|   2097152|     100|0.34521282|  PASSED  
            diehard_opso|   0|   2097152|     100|0.54401393|  PASSED  
            diehard_oqso|   0|   2097152|     100|0.97264060|  PASSED  
            diehard_dna|   0|   2097152|     100|0.73486948|  PASSED  
    diehard_count_1s_str|   0|    256000|     100|0.84594571|  PASSED  
    diehard_count_1s_byt|   0|    256000|     100|0.99654496|   WEAK   
    diehard_parking_lot|   0|     12000|     100|0.16579004|  PASSED  
        diehard_2dsphere|   2|      8000|     100|0.09764200|  PASSED  
        diehard_3dsphere|   3|      4000|     100|0.65781643|  PASSED  
        diehard_squeeze|   0|    100000|     100|0.32238384|  PASSED  
            diehard_sums|   0|       100|     100|0.00006173|   WEAK   
            diehard_runs|   0|    100000|     100|0.40714659|  PASSED  
            diehard_runs|   0|    100000|     100|0.92579344|  PASSED  
        diehard_craps|   0|    200000|     100|0.87906861|  PASSED  
        diehard_craps|   0|    200000|     100|0.43879621|  PASSED  
    marsaglia_tsang_gcd|   0|  10000000|     100|0.66549829|  PASSED  
    marsaglia_tsang_gcd|   0|  10000000|     100|0.89806733|  PASSED  
            sts_monobit|   1|    100000|     100|0.95351289|  PASSED  
                sts_runs|   2|    100000|     100|0.12131134|  PASSED  
            sts_serial|   1|    100000|     100|0.97412953|  PASSED  
            sts_serial|   2|    100000|     100|0.72141988|  PASSED  
            sts_serial|   3|    100000|     100|0.41991329|  PASSED  
            sts_serial|   3|    100000|     100|0.24850962|  PASSED  
            sts_serial|   4|    100000|     100|0.84006711|  PASSED  
            sts_serial|   4|    100000|     100|0.34686484|  PASSED  
            sts_serial|   5|    100000|     100|0.98322227|  PASSED  
            sts_serial|   5|    100000|     100|0.91839298|  PASSED  
            sts_serial|   6|    100000|     100|0.91658953|  PASSED  
            sts_serial|   6|    100000|     100|0.85396645|  PASSED  
            sts_serial|   7|    100000|     100|0.92043072|  PASSED  
            sts_serial|   7|    100000|     100|0.95423144|  PASSED  
            sts_serial|   8|    100000|     100|0.82665121|  PASSED  
            sts_serial|   8|    100000|     100|0.82249542|  PASSED  
            sts_serial|   9|    100000|     100|0.76023847|  PASSED  
            sts_serial|   9|    100000|     100|0.61968221|  PASSED  
            sts_serial|  10|    100000|     100|0.95381810|  PASSED  
            sts_serial|  10|    100000|     100|0.81718989|  PASSED  
            sts_serial|  11|    100000|     100|0.75057613|  PASSED  
            sts_serial|  11|    100000|     100|0.45754312|  PASSED  
            sts_serial|  12|    100000|     100|0.99518713|   WEAK   
            sts_serial|  12|    100000|     100|0.15681244|  PASSED  
            sts_serial|  13|    100000|     100|0.97870701|  PASSED  
            sts_serial|  13|    100000|     100|0.83039179|  PASSED  
            sts_serial|  14|    100000|     100|0.91894441|  PASSED  
            sts_serial|  14|    100000|     100|0.72417371|  PASSED  
            sts_serial|  15|    100000|     100|0.96868750|  PASSED  
            sts_serial|  15|    100000|     100|0.31404562|  PASSED  
            sts_serial|  16|    100000|     100|0.27863324|  PASSED  
            sts_serial|  16|    100000|     100|0.46919741|  PASSED  
            rgb_bitdist|   1|    100000|     100|0.78048017|  PASSED  
            rgb_bitdist|   2|    100000|     100|0.04226494|  PASSED  
            rgb_bitdist|   3|    100000|     100|0.99268879|  PASSED  
            rgb_bitdist|   4|    100000|     100|0.78214920|  PASSED  
            rgb_bitdist|   5|    100000|     100|0.52822033|  PASSED  
            rgb_bitdist|   6|    100000|     100|0.46524635|  PASSED  
            rgb_bitdist|   7|    100000|     100|0.76542574|  PASSED  
            rgb_bitdist|   8|    100000|     100|0.65448512|  PASSED  
            rgb_bitdist|   9|    100000|     100|0.72629780|  PASSED  
            rgb_bitdist|  10|    100000|     100|0.48681660|  PASSED  
            rgb_bitdist|  11|    100000|     100|0.37085063|  PASSED  
            rgb_bitdist|  12|    100000|     100|0.10577468|  PASSED  
    rgb_minimum_distance|   2|     10000|    1000|0.82130303|  PASSED  
    rgb_minimum_distance|   3|     10000|    1000|0.30429144|  PASSED  
    rgb_minimum_distance|   4|     10000|    1000|0.27524985|  PASSED  
    rgb_minimum_distance|   5|     10000|    1000|0.41460262|  PASSED  
        rgb_permutations|   2|    100000|     100|0.77622141|  PASSED  
        rgb_permutations|   3|    100000|     100|0.27314395|  PASSED  
        rgb_permutations|   4|    100000|     100|0.94749460|  PASSED  
        rgb_permutations|   5|    100000|     100|0.84713291|  PASSED  
        rgb_lagged_sum|   0|   1000000|     100|0.67331428|  PASSED  
        rgb_lagged_sum|   1|   1000000|     100|0.96310736|  PASSED  
        rgb_lagged_sum|   2|   1000000|     100|0.51528870|  PASSED  
        rgb_lagged_sum|   3|   1000000|     100|0.81921675|  PASSED  
        rgb_lagged_sum|   4|   1000000|     100|0.75548273|  PASSED  
        rgb_lagged_sum|   5|   1000000|     100|0.29086263|  PASSED  
        rgb_lagged_sum|   6|   1000000|     100|0.65737407|  PASSED  
        rgb_lagged_sum|   7|   1000000|     100|0.10036028|  PASSED  
        rgb_lagged_sum|   8|   1000000|     100|0.39018451|  PASSED  
        rgb_lagged_sum|   9|   1000000|     100|0.68862191|  PASSED  
        rgb_lagged_sum|  10|   1000000|     100|0.52523376|  PASSED  
        rgb_lagged_sum|  11|   1000000|     100|0.92499755|  PASSED  
        rgb_lagged_sum|  12|   1000000|     100|0.36025902|  PASSED  
        rgb_lagged_sum|  13|   1000000|     100|0.87407808|  PASSED  
        rgb_lagged_sum|  14|   1000000|     100|0.97776005|  PASSED  
        rgb_lagged_sum|  15|   1000000|     100|0.11820028|  PASSED  
        rgb_lagged_sum|  16|   1000000|     100|0.81348352|  PASSED  
        rgb_lagged_sum|  17|   1000000|     100|0.91449856|  PASSED  
        rgb_lagged_sum|  18|   1000000|     100|0.33219011|  PASSED  
        rgb_lagged_sum|  19|   1000000|     100|0.99781403|   WEAK   
        rgb_lagged_sum|  20|   1000000|     100|0.24345810|  PASSED  
        rgb_lagged_sum|  21|   1000000|     100|0.57439693|  PASSED  
        rgb_lagged_sum|  22|   1000000|     100|0.91826468|  PASSED  
        rgb_lagged_sum|  23|   1000000|     100|0.04957811|  PASSED  
        rgb_lagged_sum|  24|   1000000|     100|0.52214247|  PASSED  
        rgb_lagged_sum|  25|   1000000|     100|0.56535620|  PASSED  
        rgb_lagged_sum|  26|   1000000|     100|0.70246357|  PASSED  
        rgb_lagged_sum|  27|   1000000|     100|0.62212259|  PASSED  
        rgb_lagged_sum|  28|   1000000|     100|0.92206734|  PASSED  
        rgb_lagged_sum|  29|   1000000|     100|0.27184801|  PASSED  
        rgb_lagged_sum|  30|   1000000|     100|0.63423190|  PASSED  
        rgb_lagged_sum|  31|   1000000|     100|0.90596251|  PASSED  
        rgb_lagged_sum|  32|   1000000|     100|0.54377554|  PASSED  
        rgb_kstest_test|   0|     10000|    1000|0.97969530|  PASSED  
        dab_bytedistrib|   0|  51200000|       1|0.07983552|  PASSED  
                dab_dct| 256|     50000|       1|0.23484508|  PASSED  
    Preparing to run test 207.  ntuple = 0
            dab_filltree|  32|  15000000|       1|0.83205264|  PASSED  
            dab_filltree|  32|  15000000|       1|0.33233283|  PASSED  
    Preparing to run test 208.  ntuple = 0
        dab_filltree2|   0|   5000000|       1|0.09380571|  PASSED  
        dab_filltree2|   1|   5000000|       1|0.55990520|  PASSED  
    Preparing to run test 209.  ntuple = 0
            dab_monobit2|  12|  65000000|       1|0.41605125|  PASSED  
    #=============================================================================#
    # Summary: PASSED=109, WEAK=5, FAILED=0                                       #
    #          235,031.266 MB of random data created with 149.258 MB/sec          #
    #=============================================================================#
    #=============================================================================#
    # Runtime: 0:26:14                                                            #
    #=============================================================================#
    
## LCG64ShiftRandom    
    
    #=============================================================================#
    # Testing: io.jenetics.prngine.LCG64ShiftRandom (2017-03-02 23:14)            #
    #=============================================================================#
    #=============================================================================#
    # Linux 4.8.0-40-generic (amd64)                                              #
    # java version "1.8.0_112"                                                    #
    # Java(TM) SE Runtime Environment (build 1.8.0_112-b15)                       #
    # Java HotSpot(TM) 64-Bit Server VM (build 25.112-b15)                        #
    #=============================================================================#
    #=============================================================================#
    #            dieharder version 3.31.1 Copyright 2003 Robert G. Brown          #
    #=============================================================================#
    rng_name    |rands/second|   Seed   |
    stdin_input_raw|  6.52e+07  |1573482630|
    #=============================================================================#
            test_name   |ntup| tsamples |psamples|  p-value |Assessment
    #=============================================================================#
    diehard_birthdays|   0|       100|     100|0.46705309|  PASSED  
        diehard_operm5|   0|   1000000|     100|0.16521075|  PASSED  
    diehard_rank_32x32|   0|     40000|     100|0.53128848|  PASSED  
        diehard_rank_6x8|   0|    100000|     100|0.40687217|  PASSED  
    diehard_bitstream|   0|   2097152|     100|0.09542048|  PASSED  
            diehard_opso|   0|   2097152|     100|0.69114691|  PASSED  
            diehard_oqso|   0|   2097152|     100|0.83640271|  PASSED  
            diehard_dna|   0|   2097152|     100|0.42341150|  PASSED  
    diehard_count_1s_str|   0|    256000|     100|0.39154761|  PASSED  
    diehard_count_1s_byt|   0|    256000|     100|0.09156740|  PASSED  
    diehard_parking_lot|   0|     12000|     100|0.45685225|  PASSED  
        diehard_2dsphere|   2|      8000|     100|0.82926760|  PASSED  
        diehard_3dsphere|   3|      4000|     100|0.85884747|  PASSED  
        diehard_squeeze|   0|    100000|     100|0.31623681|  PASSED  
            diehard_sums|   0|       100|     100|0.67200209|  PASSED  
            diehard_runs|   0|    100000|     100|0.25266665|  PASSED  
            diehard_runs|   0|    100000|     100|0.15521419|  PASSED  
        diehard_craps|   0|    200000|     100|0.91020433|  PASSED  
        diehard_craps|   0|    200000|     100|0.52678230|  PASSED  
    marsaglia_tsang_gcd|   0|  10000000|     100|0.73941970|  PASSED  
    marsaglia_tsang_gcd|   0|  10000000|     100|0.96009959|  PASSED  
            sts_monobit|   1|    100000|     100|0.89647372|  PASSED  
                sts_runs|   2|    100000|     100|0.80941304|  PASSED  
            sts_serial|   1|    100000|     100|0.92133643|  PASSED  
            sts_serial|   2|    100000|     100|0.73332149|  PASSED  
            sts_serial|   3|    100000|     100|0.98330874|  PASSED  
            sts_serial|   3|    100000|     100|0.90283041|  PASSED  
            sts_serial|   4|    100000|     100|0.53272805|  PASSED  
            sts_serial|   4|    100000|     100|0.89522579|  PASSED  
            sts_serial|   5|    100000|     100|0.44005439|  PASSED  
            sts_serial|   5|    100000|     100|0.30976806|  PASSED  
            sts_serial|   6|    100000|     100|0.87886686|  PASSED  
            sts_serial|   6|    100000|     100|0.09530016|  PASSED  
            sts_serial|   7|    100000|     100|0.08244730|  PASSED  
            sts_serial|   7|    100000|     100|0.32565327|  PASSED  
            sts_serial|   8|    100000|     100|0.99323861|  PASSED  
            sts_serial|   8|    100000|     100|0.60755294|  PASSED  
            sts_serial|   9|    100000|     100|0.29608499|  PASSED  
            sts_serial|   9|    100000|     100|0.96084372|  PASSED  
            sts_serial|  10|    100000|     100|0.50161693|  PASSED  
            sts_serial|  10|    100000|     100|0.93422706|  PASSED  
            sts_serial|  11|    100000|     100|0.41350516|  PASSED  
            sts_serial|  11|    100000|     100|0.35540794|  PASSED  
            sts_serial|  12|    100000|     100|0.39104382|  PASSED  
            sts_serial|  12|    100000|     100|0.52562191|  PASSED  
            sts_serial|  13|    100000|     100|0.31292170|  PASSED  
            sts_serial|  13|    100000|     100|0.19051973|  PASSED  
            sts_serial|  14|    100000|     100|0.07289244|  PASSED  
            sts_serial|  14|    100000|     100|0.58458055|  PASSED  
            sts_serial|  15|    100000|     100|0.28272929|  PASSED  
            sts_serial|  15|    100000|     100|0.86014692|  PASSED  
            sts_serial|  16|    100000|     100|0.04107963|  PASSED  
            sts_serial|  16|    100000|     100|0.33756272|  PASSED  
            rgb_bitdist|   1|    100000|     100|0.77312239|  PASSED  
            rgb_bitdist|   2|    100000|     100|0.98042773|  PASSED  
            rgb_bitdist|   3|    100000|     100|0.20767808|  PASSED  
            rgb_bitdist|   4|    100000|     100|0.09417324|  PASSED  
            rgb_bitdist|   5|    100000|     100|0.30094970|  PASSED  
            rgb_bitdist|   6|    100000|     100|0.09912594|  PASSED  
            rgb_bitdist|   7|    100000|     100|0.86324718|  PASSED  
            rgb_bitdist|   8|    100000|     100|0.34346280|  PASSED  
            rgb_bitdist|   9|    100000|     100|0.81372528|  PASSED  
            rgb_bitdist|  10|    100000|     100|0.36676474|  PASSED  
            rgb_bitdist|  11|    100000|     100|0.97989648|  PASSED  
            rgb_bitdist|  12|    100000|     100|0.57493584|  PASSED  
    rgb_minimum_distance|   2|     10000|    1000|0.47009563|  PASSED  
    rgb_minimum_distance|   3|     10000|    1000|0.19788158|  PASSED  
    rgb_minimum_distance|   4|     10000|    1000|0.66870712|  PASSED  
    rgb_minimum_distance|   5|     10000|    1000|0.14398031|  PASSED  
        rgb_permutations|   2|    100000|     100|0.48181086|  PASSED  
        rgb_permutations|   3|    100000|     100|0.99803725|   WEAK   
        rgb_permutations|   4|    100000|     100|0.53430277|  PASSED  
        rgb_permutations|   5|    100000|     100|0.28595313|  PASSED  
        rgb_lagged_sum|   0|   1000000|     100|0.82297798|  PASSED  
        rgb_lagged_sum|   1|   1000000|     100|0.55027845|  PASSED  
        rgb_lagged_sum|   2|   1000000|     100|0.75157129|  PASSED  
        rgb_lagged_sum|   3|   1000000|     100|0.96884704|  PASSED  
        rgb_lagged_sum|   4|   1000000|     100|0.19973937|  PASSED  
        rgb_lagged_sum|   5|   1000000|     100|0.59685172|  PASSED  
        rgb_lagged_sum|   6|   1000000|     100|0.72555592|  PASSED  
        rgb_lagged_sum|   7|   1000000|     100|0.64069216|  PASSED  
        rgb_lagged_sum|   8|   1000000|     100|0.28863973|  PASSED  
        rgb_lagged_sum|   9|   1000000|     100|0.15214483|  PASSED  
        rgb_lagged_sum|  10|   1000000|     100|0.02715910|  PASSED  
        rgb_lagged_sum|  11|   1000000|     100|0.63230785|  PASSED  
        rgb_lagged_sum|  12|   1000000|     100|0.84923899|  PASSED  
        rgb_lagged_sum|  13|   1000000|     100|0.52988210|  PASSED  
        rgb_lagged_sum|  14|   1000000|     100|0.17969131|  PASSED  
        rgb_lagged_sum|  15|   1000000|     100|0.99525548|   WEAK   
        rgb_lagged_sum|  16|   1000000|     100|0.99525362|   WEAK   
        rgb_lagged_sum|  17|   1000000|     100|0.09024985|  PASSED  
        rgb_lagged_sum|  18|   1000000|     100|0.20704692|  PASSED  
        rgb_lagged_sum|  19|   1000000|     100|0.53705720|  PASSED  
        rgb_lagged_sum|  20|   1000000|     100|0.74352848|  PASSED  
        rgb_lagged_sum|  21|   1000000|     100|0.98689197|  PASSED  
        rgb_lagged_sum|  22|   1000000|     100|0.06043283|  PASSED  
        rgb_lagged_sum|  23|   1000000|     100|0.78372880|  PASSED  
        rgb_lagged_sum|  24|   1000000|     100|0.69838455|  PASSED  
        rgb_lagged_sum|  25|   1000000|     100|0.48275229|  PASSED  
        rgb_lagged_sum|  26|   1000000|     100|0.01560332|  PASSED  
        rgb_lagged_sum|  27|   1000000|     100|0.99904629|   WEAK   
        rgb_lagged_sum|  28|   1000000|     100|0.89849878|  PASSED  
        rgb_lagged_sum|  29|   1000000|     100|0.78145049|  PASSED  
        rgb_lagged_sum|  30|   1000000|     100|0.18578173|  PASSED  
        rgb_lagged_sum|  31|   1000000|     100|0.18581373|  PASSED  
        rgb_lagged_sum|  32|   1000000|     100|0.91800548|  PASSED  
        rgb_kstest_test|   0|     10000|    1000|0.44530842|  PASSED  
        dab_bytedistrib|   0|  51200000|       1|0.96328208|  PASSED  
                dab_dct| 256|     50000|       1|0.90969773|  PASSED  
    Preparing to run test 207.  ntuple = 0
            dab_filltree|  32|  15000000|       1|0.93893587|  PASSED  
            dab_filltree|  32|  15000000|       1|0.53214679|  PASSED  
    Preparing to run test 208.  ntuple = 0
        dab_filltree2|   0|   5000000|       1|0.11106784|  PASSED  
        dab_filltree2|   1|   5000000|       1|0.69016860|  PASSED  
    Preparing to run test 209.  ntuple = 0
            dab_monobit2|  12|  65000000|       1|0.55832119|  PASSED  
    #=============================================================================#
    # Summary: PASSED=110, WEAK=4, FAILED=0                                       #
    #          235,031.141 MB of random data created with 149.216 MB/sec          #
    #=============================================================================#
    #=============================================================================#
    # Runtime: 0:26:15                                                            #
    #=============================================================================#
    
## MT19937_32Random    
    
    #=============================================================================#
    # Testing: io.jenetics.prngine.MT19937_32Random (2017-03-02 23:40)            #
    #=============================================================================#
    #=============================================================================#
    # Linux 4.8.0-40-generic (amd64)                                              #
    # java version "1.8.0_112"                                                    #
    # Java(TM) SE Runtime Environment (build 1.8.0_112-b15)                       #
    # Java HotSpot(TM) 64-Bit Server VM (build 25.112-b15)                        #
    #=============================================================================#
    #=============================================================================#
    #            dieharder version 3.31.1 Copyright 2003 Robert G. Brown          #
    #=============================================================================#
    rng_name    |rands/second|   Seed   |
    stdin_input_raw|  6.17e+07  | 200717383|
    #=============================================================================#
            test_name   |ntup| tsamples |psamples|  p-value |Assessment
    #=============================================================================#
    diehard_birthdays|   0|       100|     100|0.97561059|  PASSED  
        diehard_operm5|   0|   1000000|     100|0.27394625|  PASSED  
    diehard_rank_32x32|   0|     40000|     100|0.93679861|  PASSED  
        diehard_rank_6x8|   0|    100000|     100|0.10389765|  PASSED  
    diehard_bitstream|   0|   2097152|     100|0.98033995|  PASSED  
            diehard_opso|   0|   2097152|     100|0.68738079|  PASSED  
            diehard_oqso|   0|   2097152|     100|0.25579262|  PASSED  
            diehard_dna|   0|   2097152|     100|0.96626854|  PASSED  
    diehard_count_1s_str|   0|    256000|     100|0.03465589|  PASSED  
    diehard_count_1s_byt|   0|    256000|     100|0.97443750|  PASSED  
    diehard_parking_lot|   0|     12000|     100|0.90162649|  PASSED  
        diehard_2dsphere|   2|      8000|     100|0.23263990|  PASSED  
        diehard_3dsphere|   3|      4000|     100|0.69599967|  PASSED  
        diehard_squeeze|   0|    100000|     100|0.54298592|  PASSED  
            diehard_sums|   0|       100|     100|0.40964265|  PASSED  
            diehard_runs|   0|    100000|     100|0.36510148|  PASSED  
            diehard_runs|   0|    100000|     100|0.41367826|  PASSED  
        diehard_craps|   0|    200000|     100|0.50353352|  PASSED  
        diehard_craps|   0|    200000|     100|0.69088932|  PASSED  
    marsaglia_tsang_gcd|   0|  10000000|     100|0.81043441|  PASSED  
    marsaglia_tsang_gcd|   0|  10000000|     100|0.08817339|  PASSED  
            sts_monobit|   1|    100000|     100|0.38549938|  PASSED  
                sts_runs|   2|    100000|     100|0.84878563|  PASSED  
            sts_serial|   1|    100000|     100|0.11502032|  PASSED  
            sts_serial|   2|    100000|     100|0.57213247|  PASSED  
            sts_serial|   3|    100000|     100|0.32206688|  PASSED  
            sts_serial|   3|    100000|     100|0.77090176|  PASSED  
            sts_serial|   4|    100000|     100|0.64930407|  PASSED  
            sts_serial|   4|    100000|     100|0.23232371|  PASSED  
            sts_serial|   5|    100000|     100|0.84257617|  PASSED  
            sts_serial|   5|    100000|     100|0.55218010|  PASSED  
            sts_serial|   6|    100000|     100|0.05007583|  PASSED  
            sts_serial|   6|    100000|     100|0.05758855|  PASSED  
            sts_serial|   7|    100000|     100|0.03252747|  PASSED  
            sts_serial|   7|    100000|     100|0.99612037|   WEAK   
            sts_serial|   8|    100000|     100|0.73247505|  PASSED  
            sts_serial|   8|    100000|     100|0.77826015|  PASSED  
            sts_serial|   9|    100000|     100|0.69076392|  PASSED  
            sts_serial|   9|    100000|     100|0.19182545|  PASSED  
            sts_serial|  10|    100000|     100|0.27316197|  PASSED  
            sts_serial|  10|    100000|     100|0.34372977|  PASSED  
            sts_serial|  11|    100000|     100|0.50569071|  PASSED  
            sts_serial|  11|    100000|     100|0.81499418|  PASSED  
            sts_serial|  12|    100000|     100|0.26194364|  PASSED  
            sts_serial|  12|    100000|     100|0.06034193|  PASSED  
            sts_serial|  13|    100000|     100|0.31738364|  PASSED  
            sts_serial|  13|    100000|     100|0.68279318|  PASSED  
            sts_serial|  14|    100000|     100|0.79175994|  PASSED  
            sts_serial|  14|    100000|     100|0.35669397|  PASSED  
            sts_serial|  15|    100000|     100|0.94529501|  PASSED  
            sts_serial|  15|    100000|     100|0.58824655|  PASSED  
            sts_serial|  16|    100000|     100|0.22007126|  PASSED  
            sts_serial|  16|    100000|     100|0.70627827|  PASSED  
            rgb_bitdist|   1|    100000|     100|0.31539027|  PASSED  
            rgb_bitdist|   2|    100000|     100|0.74761744|  PASSED  
            rgb_bitdist|   3|    100000|     100|0.63063882|  PASSED  
            rgb_bitdist|   4|    100000|     100|0.08590380|  PASSED  
            rgb_bitdist|   5|    100000|     100|0.17619276|  PASSED  
            rgb_bitdist|   6|    100000|     100|0.24066684|  PASSED  
            rgb_bitdist|   7|    100000|     100|0.10610519|  PASSED  
            rgb_bitdist|   8|    100000|     100|0.39619063|  PASSED  
            rgb_bitdist|   9|    100000|     100|0.99410102|  PASSED  
            rgb_bitdist|  10|    100000|     100|0.34763261|  PASSED  
            rgb_bitdist|  11|    100000|     100|0.84408896|  PASSED  
            rgb_bitdist|  12|    100000|     100|0.22333339|  PASSED  
    rgb_minimum_distance|   2|     10000|    1000|0.36550655|  PASSED  
    rgb_minimum_distance|   3|     10000|    1000|0.37057184|  PASSED  
    rgb_minimum_distance|   4|     10000|    1000|0.95006432|  PASSED  
    rgb_minimum_distance|   5|     10000|    1000|0.90659611|  PASSED  
        rgb_permutations|   2|    100000|     100|0.64673367|  PASSED  
        rgb_permutations|   3|    100000|     100|0.97779930|  PASSED  
        rgb_permutations|   4|    100000|     100|0.62537720|  PASSED  
        rgb_permutations|   5|    100000|     100|0.54536226|  PASSED  
        rgb_lagged_sum|   0|   1000000|     100|0.90835540|  PASSED  
        rgb_lagged_sum|   1|   1000000|     100|0.66444737|  PASSED  
        rgb_lagged_sum|   2|   1000000|     100|0.76726956|  PASSED  
        rgb_lagged_sum|   3|   1000000|     100|0.86769655|  PASSED  
        rgb_lagged_sum|   4|   1000000|     100|0.61252705|  PASSED  
        rgb_lagged_sum|   5|   1000000|     100|0.74110172|  PASSED  
        rgb_lagged_sum|   6|   1000000|     100|0.43652626|  PASSED  
        rgb_lagged_sum|   7|   1000000|     100|0.96139695|  PASSED  
        rgb_lagged_sum|   8|   1000000|     100|0.35885005|  PASSED  
        rgb_lagged_sum|   9|   1000000|     100|0.43222950|  PASSED  
        rgb_lagged_sum|  10|   1000000|     100|0.94272101|  PASSED  
        rgb_lagged_sum|  11|   1000000|     100|0.78049068|  PASSED  
        rgb_lagged_sum|  12|   1000000|     100|0.07710770|  PASSED  
        rgb_lagged_sum|  13|   1000000|     100|0.98007916|  PASSED  
        rgb_lagged_sum|  14|   1000000|     100|0.56082360|  PASSED  
        rgb_lagged_sum|  15|   1000000|     100|0.92601043|  PASSED  
        rgb_lagged_sum|  16|   1000000|     100|0.55562456|  PASSED  
        rgb_lagged_sum|  17|   1000000|     100|0.05106600|  PASSED  
        rgb_lagged_sum|  18|   1000000|     100|0.25059384|  PASSED  
        rgb_lagged_sum|  19|   1000000|     100|0.06230300|  PASSED  
        rgb_lagged_sum|  20|   1000000|     100|0.42160059|  PASSED  
        rgb_lagged_sum|  21|   1000000|     100|0.72383215|  PASSED  
        rgb_lagged_sum|  22|   1000000|     100|0.22058888|  PASSED  
        rgb_lagged_sum|  23|   1000000|     100|0.26103266|  PASSED  
        rgb_lagged_sum|  24|   1000000|     100|0.50706821|  PASSED  
        rgb_lagged_sum|  25|   1000000|     100|0.61204857|  PASSED  
        rgb_lagged_sum|  26|   1000000|     100|0.82256123|  PASSED  
        rgb_lagged_sum|  27|   1000000|     100|0.92342305|  PASSED  
        rgb_lagged_sum|  28|   1000000|     100|0.93770783|  PASSED  
        rgb_lagged_sum|  29|   1000000|     100|0.98722089|  PASSED  
        rgb_lagged_sum|  30|   1000000|     100|0.86943324|  PASSED  
        rgb_lagged_sum|  31|   1000000|     100|0.84728683|  PASSED  
        rgb_lagged_sum|  32|   1000000|     100|0.18442607|  PASSED  
        rgb_kstest_test|   0|     10000|    1000|0.59084249|  PASSED  
        dab_bytedistrib|   0|  51200000|       1|0.38601222|  PASSED  
                dab_dct| 256|     50000|       1|0.64463863|  PASSED  
    Preparing to run test 207.  ntuple = 0
            dab_filltree|  32|  15000000|       1|0.81558783|  PASSED  
            dab_filltree|  32|  15000000|       1|0.03050294|  PASSED  
    Preparing to run test 208.  ntuple = 0
        dab_filltree2|   0|   5000000|       1|0.82544606|  PASSED  
        dab_filltree2|   1|   5000000|       1|0.45332743|  PASSED  
    Preparing to run test 209.  ntuple = 0
            dab_monobit2|  12|  65000000|       1|0.39960837|  PASSED  
    #=============================================================================#
    # Summary: PASSED=113, WEAK=1, FAILED=0                                       #
    #          235,031.125 MB of random data created with 150.405 MB/sec          #
    #=============================================================================#
    #=============================================================================#
    # Runtime: 0:26:02                                                            #
    #=============================================================================#
    
## MT19937_64Random    
    
    #=============================================================================#
    # Testing: io.jenetics.prngine.MT19937_64Random (2017-03-03 00:06)            #
    #=============================================================================#
    #=============================================================================#
    # Linux 4.8.0-40-generic (amd64)                                              #
    # java version "1.8.0_112"                                                    #
    # Java(TM) SE Runtime Environment (build 1.8.0_112-b15)                       #
    # Java HotSpot(TM) 64-Bit Server VM (build 25.112-b15)                        #
    #=============================================================================#
    #=============================================================================#
    #            dieharder version 3.31.1 Copyright 2003 Robert G. Brown          #
    #=============================================================================#
    rng_name    |rands/second|   Seed   |
    stdin_input_raw|  5.01e+07  |2254556692|
    #=============================================================================#
            test_name   |ntup| tsamples |psamples|  p-value |Assessment
    #=============================================================================#
    diehard_birthdays|   0|       100|     100|0.34940479|  PASSED  
        diehard_operm5|   0|   1000000|     100|0.14362536|  PASSED  
    diehard_rank_32x32|   0|     40000|     100|0.27465525|  PASSED  
        diehard_rank_6x8|   0|    100000|     100|0.33924452|  PASSED  
    diehard_bitstream|   0|   2097152|     100|0.85377650|  PASSED  
            diehard_opso|   0|   2097152|     100|0.68665629|  PASSED  
            diehard_oqso|   0|   2097152|     100|0.36049743|  PASSED  
            diehard_dna|   0|   2097152|     100|0.17651936|  PASSED  
    diehard_count_1s_str|   0|    256000|     100|0.96188161|  PASSED  
    diehard_count_1s_byt|   0|    256000|     100|0.75810190|  PASSED  
    diehard_parking_lot|   0|     12000|     100|0.77335420|  PASSED  
        diehard_2dsphere|   2|      8000|     100|0.03026034|  PASSED  
        diehard_3dsphere|   3|      4000|     100|0.98805590|  PASSED  
        diehard_squeeze|   0|    100000|     100|0.42629781|  PASSED  
            diehard_sums|   0|       100|     100|0.01086725|  PASSED  
            diehard_runs|   0|    100000|     100|0.51651242|  PASSED  
            diehard_runs|   0|    100000|     100|0.81622426|  PASSED  
        diehard_craps|   0|    200000|     100|0.91097646|  PASSED  
        diehard_craps|   0|    200000|     100|0.31941878|  PASSED  
    marsaglia_tsang_gcd|   0|  10000000|     100|0.82008659|  PASSED  
    marsaglia_tsang_gcd|   0|  10000000|     100|0.56491368|  PASSED  
            sts_monobit|   1|    100000|     100|0.27628820|  PASSED  
                sts_runs|   2|    100000|     100|0.49269424|  PASSED  
            sts_serial|   1|    100000|     100|0.74971687|  PASSED  
            sts_serial|   2|    100000|     100|0.38354472|  PASSED  
            sts_serial|   3|    100000|     100|0.77253697|  PASSED  
            sts_serial|   3|    100000|     100|0.76558234|  PASSED  
            sts_serial|   4|    100000|     100|0.45925143|  PASSED  
            sts_serial|   4|    100000|     100|0.62316320|  PASSED  
            sts_serial|   5|    100000|     100|0.01441943|  PASSED  
            sts_serial|   5|    100000|     100|0.10570737|  PASSED  
            sts_serial|   6|    100000|     100|0.05393713|  PASSED  
            sts_serial|   6|    100000|     100|0.79230564|  PASSED  
            sts_serial|   7|    100000|     100|0.25043440|  PASSED  
            sts_serial|   7|    100000|     100|0.18451109|  PASSED  
            sts_serial|   8|    100000|     100|0.10317256|  PASSED  
            sts_serial|   8|    100000|     100|0.44507727|  PASSED  
            sts_serial|   9|    100000|     100|0.00569987|  PASSED  
            sts_serial|   9|    100000|     100|0.63198374|  PASSED  
            sts_serial|  10|    100000|     100|0.03230257|  PASSED  
            sts_serial|  10|    100000|     100|0.99099164|  PASSED  
            sts_serial|  11|    100000|     100|0.00360914|   WEAK   
            sts_serial|  11|    100000|     100|0.17135697|  PASSED  
            sts_serial|  12|    100000|     100|0.10771480|  PASSED  
            sts_serial|  12|    100000|     100|0.62922629|  PASSED  
            sts_serial|  13|    100000|     100|0.01373128|  PASSED  
            sts_serial|  13|    100000|     100|0.17783345|  PASSED  
            sts_serial|  14|    100000|     100|0.57675260|  PASSED  
            sts_serial|  14|    100000|     100|0.02914065|  PASSED  
            sts_serial|  15|    100000|     100|0.96148637|  PASSED  
            sts_serial|  15|    100000|     100|0.43848164|  PASSED  
            sts_serial|  16|    100000|     100|0.38646229|  PASSED  
            sts_serial|  16|    100000|     100|0.52706940|  PASSED  
            rgb_bitdist|   1|    100000|     100|0.05486049|  PASSED  
            rgb_bitdist|   2|    100000|     100|0.91045662|  PASSED  
            rgb_bitdist|   3|    100000|     100|0.80966682|  PASSED  
            rgb_bitdist|   4|    100000|     100|0.15806148|  PASSED  
            rgb_bitdist|   5|    100000|     100|0.71566229|  PASSED  
            rgb_bitdist|   6|    100000|     100|0.40709307|  PASSED  
            rgb_bitdist|   7|    100000|     100|0.47193990|  PASSED  
            rgb_bitdist|   8|    100000|     100|0.36629199|  PASSED  
            rgb_bitdist|   9|    100000|     100|0.98771844|  PASSED  
            rgb_bitdist|  10|    100000|     100|0.91184226|  PASSED  
            rgb_bitdist|  11|    100000|     100|0.04590658|  PASSED  
            rgb_bitdist|  12|    100000|     100|0.65370447|  PASSED  
    rgb_minimum_distance|   2|     10000|    1000|0.77635166|  PASSED  
    rgb_minimum_distance|   3|     10000|    1000|0.19917821|  PASSED  
    rgb_minimum_distance|   4|     10000|    1000|0.80915164|  PASSED  
    rgb_minimum_distance|   5|     10000|    1000|0.97768498|  PASSED  
        rgb_permutations|   2|    100000|     100|0.80856629|  PASSED  
        rgb_permutations|   3|    100000|     100|0.03518342|  PASSED  
        rgb_permutations|   4|    100000|     100|0.36244765|  PASSED  
        rgb_permutations|   5|    100000|     100|0.63221038|  PASSED  
        rgb_lagged_sum|   0|   1000000|     100|0.52220502|  PASSED  
        rgb_lagged_sum|   1|   1000000|     100|0.24565518|  PASSED  
        rgb_lagged_sum|   2|   1000000|     100|0.91862593|  PASSED  
        rgb_lagged_sum|   3|   1000000|     100|0.12471913|  PASSED  
        rgb_lagged_sum|   4|   1000000|     100|0.00594232|  PASSED  
        rgb_lagged_sum|   5|   1000000|     100|0.05338306|  PASSED  
        rgb_lagged_sum|   6|   1000000|     100|0.25361771|  PASSED  
        rgb_lagged_sum|   7|   1000000|     100|0.97775021|  PASSED  
        rgb_lagged_sum|   8|   1000000|     100|0.27325688|  PASSED  
        rgb_lagged_sum|   9|   1000000|     100|0.30766005|  PASSED  
        rgb_lagged_sum|  10|   1000000|     100|0.53072100|  PASSED  
        rgb_lagged_sum|  11|   1000000|     100|0.86505449|  PASSED  
        rgb_lagged_sum|  12|   1000000|     100|0.52269268|  PASSED  
        rgb_lagged_sum|  13|   1000000|     100|0.04384853|  PASSED  
        rgb_lagged_sum|  14|   1000000|     100|0.39201679|  PASSED  
        rgb_lagged_sum|  15|   1000000|     100|0.99987937|   WEAK   
        rgb_lagged_sum|  16|   1000000|     100|0.26931039|  PASSED  
        rgb_lagged_sum|  17|   1000000|     100|0.80238196|  PASSED  
        rgb_lagged_sum|  18|   1000000|     100|0.34439416|  PASSED  
        rgb_lagged_sum|  19|   1000000|     100|0.11256060|  PASSED  
        rgb_lagged_sum|  20|   1000000|     100|0.44782954|  PASSED  
        rgb_lagged_sum|  21|   1000000|     100|0.92498713|  PASSED  
        rgb_lagged_sum|  22|   1000000|     100|0.12499012|  PASSED  
        rgb_lagged_sum|  23|   1000000|     100|0.90349699|  PASSED  
        rgb_lagged_sum|  24|   1000000|     100|0.57186506|  PASSED  
        rgb_lagged_sum|  25|   1000000|     100|0.93407565|  PASSED  
        rgb_lagged_sum|  26|   1000000|     100|0.67990340|  PASSED  
        rgb_lagged_sum|  27|   1000000|     100|0.66018274|  PASSED  
        rgb_lagged_sum|  28|   1000000|     100|0.95717395|  PASSED  
        rgb_lagged_sum|  29|   1000000|     100|0.61460325|  PASSED  
        rgb_lagged_sum|  30|   1000000|     100|0.45157394|  PASSED  
        rgb_lagged_sum|  31|   1000000|     100|0.42365674|  PASSED  
        rgb_lagged_sum|  32|   1000000|     100|0.58524571|  PASSED  
        rgb_kstest_test|   0|     10000|    1000|0.03914176|  PASSED  
        dab_bytedistrib|   0|  51200000|       1|0.38408043|  PASSED  
                dab_dct| 256|     50000|       1|0.37975101|  PASSED  
    Preparing to run test 207.  ntuple = 0
            dab_filltree|  32|  15000000|       1|0.01782685|  PASSED  
            dab_filltree|  32|  15000000|       1|0.99946433|   WEAK   
    Preparing to run test 208.  ntuple = 0
        dab_filltree2|   0|   5000000|       1|0.99459973|  PASSED  
        dab_filltree2|   1|   5000000|       1|0.59626691|  PASSED  
    Preparing to run test 209.  ntuple = 0
            dab_monobit2|  12|  65000000|       1|0.91327976|  PASSED  
    #=============================================================================#
    # Summary: PASSED=111, WEAK=3, FAILED=0                                       #
    #          235,031.500 MB of random data created with 144.138 MB/sec          #
    #=============================================================================#
    #=============================================================================#
    # Runtime: 0:27:10                                                            #
    #=============================================================================#
    
## XOR32ShiftRandom    
    
    #=============================================================================#
    # Testing: io.jenetics.prngine.XOR32ShiftRandom (2017-03-03 00:34)            #
    #=============================================================================#
    #=============================================================================#
    # Linux 4.8.0-40-generic (amd64)                                              #
    # java version "1.8.0_112"                                                    #
    # Java(TM) SE Runtime Environment (build 1.8.0_112-b15)                       #
    # Java HotSpot(TM) 64-Bit Server VM (build 25.112-b15)                        #
    #=============================================================================#
    #=============================================================================#
    #            dieharder version 3.31.1 Copyright 2003 Robert G. Brown          #
    #=============================================================================#
    rng_name    |rands/second|   Seed   |
    stdin_input_raw|  6.50e+07  |3979553962|
    #=============================================================================#
            test_name   |ntup| tsamples |psamples|  p-value |Assessment
    #=============================================================================#
    diehard_birthdays|   0|       100|     100|0.88353333|  PASSED  
        diehard_operm5|   0|   1000000|     100|0.69616699|  PASSED  
    diehard_rank_32x32|   0|     40000|     100|0.00000000|  FAILED  
        diehard_rank_6x8|   0|    100000|     100|0.55516429|  PASSED  
    diehard_bitstream|   0|   2097152|     100|0.87460148|  PASSED  
            diehard_opso|   0|   2097152|     100|0.92562142|  PASSED  
            diehard_oqso|   0|   2097152|     100|0.25738086|  PASSED  
            diehard_dna|   0|   2097152|     100|0.03662864|  PASSED  
    diehard_count_1s_str|   0|    256000|     100|0.00000000|  FAILED  
    diehard_count_1s_byt|   0|    256000|     100|0.20348687|  PASSED  
    diehard_parking_lot|   0|     12000|     100|0.00000019|  FAILED  
        diehard_2dsphere|   2|      8000|     100|0.00000000|  FAILED  
        diehard_3dsphere|   3|      4000|     100|0.62001872|  PASSED  
        diehard_squeeze|   0|    100000|     100|0.87474824|  PASSED  
            diehard_sums|   0|       100|     100|0.48149733|  PASSED  
            diehard_runs|   0|    100000|     100|0.70862908|  PASSED  
            diehard_runs|   0|    100000|     100|0.11832915|  PASSED  
        diehard_craps|   0|    200000|     100|0.00794165|  PASSED  
        diehard_craps|   0|    200000|     100|0.47135815|  PASSED  
    marsaglia_tsang_gcd|   0|  10000000|     100|0.00000000|  FAILED  
    marsaglia_tsang_gcd|   0|  10000000|     100|0.12415329|  PASSED  
            sts_monobit|   1|    100000|     100|0.90498920|  PASSED  
                sts_runs|   2|    100000|     100|0.65718803|  PASSED  
            sts_serial|   1|    100000|     100|0.95268682|  PASSED  
            sts_serial|   2|    100000|     100|0.99977172|   WEAK   
            sts_serial|   3|    100000|     100|0.78624182|  PASSED  
            sts_serial|   3|    100000|     100|0.90717676|  PASSED  
            sts_serial|   4|    100000|     100|0.41264783|  PASSED  
            sts_serial|   4|    100000|     100|0.91489054|  PASSED  
            sts_serial|   5|    100000|     100|0.38093188|  PASSED  
            sts_serial|   5|    100000|     100|0.45011361|  PASSED  
            sts_serial|   6|    100000|     100|0.22161644|  PASSED  
            sts_serial|   6|    100000|     100|0.58618775|  PASSED  
            sts_serial|   7|    100000|     100|0.18456890|  PASSED  
            sts_serial|   7|    100000|     100|0.21838664|  PASSED  
            sts_serial|   8|    100000|     100|0.00353150|   WEAK   
            sts_serial|   8|    100000|     100|0.01665535|  PASSED  
            sts_serial|   9|    100000|     100|0.08668748|  PASSED  
            sts_serial|   9|    100000|     100|0.88806951|  PASSED  
            sts_serial|  10|    100000|     100|0.32547183|  PASSED  
            sts_serial|  10|    100000|     100|0.71570221|  PASSED  
            sts_serial|  11|    100000|     100|0.05497028|  PASSED  
            sts_serial|  11|    100000|     100|0.12802140|  PASSED  
            sts_serial|  12|    100000|     100|0.47598136|  PASSED  
            sts_serial|  12|    100000|     100|0.84823904|  PASSED  
            sts_serial|  13|    100000|     100|0.26365652|  PASSED  
            sts_serial|  13|    100000|     100|0.51464840|  PASSED  
            sts_serial|  14|    100000|     100|0.47361664|  PASSED  
            sts_serial|  14|    100000|     100|0.47480575|  PASSED  
            sts_serial|  15|    100000|     100|0.26564117|  PASSED  
            sts_serial|  15|    100000|     100|0.99628560|   WEAK   
            sts_serial|  16|    100000|     100|0.98507399|  PASSED  
            sts_serial|  16|    100000|     100|0.76422958|  PASSED  
            rgb_bitdist|   1|    100000|     100|0.00000000|  FAILED  
            rgb_bitdist|   2|    100000|     100|0.01356211|  PASSED  
            rgb_bitdist|   3|    100000|     100|0.00000000|  FAILED  
            rgb_bitdist|   4|    100000|     100|0.08891252|  PASSED  
            rgb_bitdist|   5|    100000|     100|0.65273584|  PASSED  
            rgb_bitdist|   6|    100000|     100|0.99932886|   WEAK   
            rgb_bitdist|   7|    100000|     100|0.74456313|  PASSED  
            rgb_bitdist|   8|    100000|     100|0.20529704|  PASSED  
            rgb_bitdist|   9|    100000|     100|0.01218978|  PASSED  
            rgb_bitdist|  10|    100000|     100|0.94410109|  PASSED  
            rgb_bitdist|  11|    100000|     100|0.41607765|  PASSED  
            rgb_bitdist|  12|    100000|     100|0.56087400|  PASSED  
    rgb_minimum_distance|   2|     10000|    1000|0.00000000|  FAILED  
    rgb_minimum_distance|   3|     10000|    1000|0.04048112|  PASSED  
    rgb_minimum_distance|   4|     10000|    1000|0.10217016|  PASSED  
    rgb_minimum_distance|   5|     10000|    1000|0.59398376|  PASSED  
        rgb_permutations|   2|    100000|     100|0.82951511|  PASSED  
        rgb_permutations|   3|    100000|     100|0.99187890|  PASSED  
        rgb_permutations|   4|    100000|     100|0.15713370|  PASSED  
        rgb_permutations|   5|    100000|     100|0.81223462|  PASSED  
        rgb_lagged_sum|   0|   1000000|     100|0.87699975|  PASSED  
        rgb_lagged_sum|   1|   1000000|     100|0.70981034|  PASSED  
        rgb_lagged_sum|   2|   1000000|     100|0.52497900|  PASSED  
        rgb_lagged_sum|   3|   1000000|     100|0.72763397|  PASSED  
        rgb_lagged_sum|   4|   1000000|     100|0.62184806|  PASSED  
        rgb_lagged_sum|   5|   1000000|     100|0.76717688|  PASSED  
        rgb_lagged_sum|   6|   1000000|     100|0.43578421|  PASSED  
        rgb_lagged_sum|   7|   1000000|     100|0.98122570|  PASSED  
        rgb_lagged_sum|   8|   1000000|     100|0.19899844|  PASSED  
        rgb_lagged_sum|   9|   1000000|     100|0.47066502|  PASSED  
        rgb_lagged_sum|  10|   1000000|     100|0.26599433|  PASSED  
        rgb_lagged_sum|  11|   1000000|     100|0.14775470|  PASSED  
        rgb_lagged_sum|  12|   1000000|     100|0.84913236|  PASSED  
        rgb_lagged_sum|  13|   1000000|     100|0.49205172|  PASSED  
        rgb_lagged_sum|  14|   1000000|     100|0.76899797|  PASSED  
        rgb_lagged_sum|  15|   1000000|     100|0.80038848|  PASSED  
        rgb_lagged_sum|  16|   1000000|     100|0.03192169|  PASSED  
        rgb_lagged_sum|  17|   1000000|     100|0.89874248|  PASSED  
        rgb_lagged_sum|  18|   1000000|     100|0.85844401|  PASSED  
        rgb_lagged_sum|  19|   1000000|     100|0.57034298|  PASSED  
        rgb_lagged_sum|  20|   1000000|     100|0.74159297|  PASSED  
        rgb_lagged_sum|  21|   1000000|     100|0.18137680|  PASSED  
        rgb_lagged_sum|  22|   1000000|     100|0.59703672|  PASSED  
        rgb_lagged_sum|  23|   1000000|     100|0.42475880|  PASSED  
        rgb_lagged_sum|  24|   1000000|     100|0.06954819|  PASSED  
        rgb_lagged_sum|  25|   1000000|     100|0.52485364|  PASSED  
        rgb_lagged_sum|  26|   1000000|     100|0.45211298|  PASSED  
        rgb_lagged_sum|  27|   1000000|     100|0.86130393|  PASSED  
        rgb_lagged_sum|  28|   1000000|     100|0.03030101|  PASSED  
        rgb_lagged_sum|  29|   1000000|     100|0.36934948|  PASSED  
        rgb_lagged_sum|  30|   1000000|     100|0.75241935|  PASSED  
        rgb_lagged_sum|  31|   1000000|     100|0.43717016|  PASSED  
        rgb_lagged_sum|  32|   1000000|     100|0.75288126|  PASSED  
        rgb_kstest_test|   0|     10000|    1000|0.09932056|  PASSED  
        dab_bytedistrib|   0|  51200000|       1|0.61636744|  PASSED  
                dab_dct| 256|     50000|       1|0.57619680|  PASSED  
    Preparing to run test 207.  ntuple = 0
            dab_filltree|  32|  15000000|       1|0.18745670|  PASSED  
            dab_filltree|  32|  15000000|       1|0.90747357|  PASSED  
    Preparing to run test 208.  ntuple = 0
        dab_filltree2|   0|   5000000|       1|0.24083709|  PASSED  
        dab_filltree2|   1|   5000000|       1|0.11919573|  PASSED  
    Preparing to run test 209.  ntuple = 0
            dab_monobit2|  12|  65000000|       1|1.00000000|  FAILED  
    #=============================================================================#
    # Summary: PASSED=101, WEAK=4, FAILED=9                                       #
    #          235,031.023 MB of random data created with 148.518 MB/sec          #
    #=============================================================================#
    #=============================================================================#
    # Runtime: 0:26:22                                                            #
    #=============================================================================#
    
## XOR64ShiftRandom    
    
    #=============================================================================#
    # Testing: io.jenetics.prngine.XOR64ShiftRandom (2017-03-03 01:00)            #
    #=============================================================================#
    #=============================================================================#
    # Linux 4.8.0-40-generic (amd64)                                              #
    # java version "1.8.0_112"                                                    #
    # Java(TM) SE Runtime Environment (build 1.8.0_112-b15)                       #
    # Java HotSpot(TM) 64-Bit Server VM (build 25.112-b15)                        #
    #=============================================================================#
    #=============================================================================#
    #            dieharder version 3.31.1 Copyright 2003 Robert G. Brown          #
    #=============================================================================#
    rng_name    |rands/second|   Seed   |
    stdin_input_raw|  6.33e+07  |3862035824|
    #=============================================================================#
            test_name   |ntup| tsamples |psamples|  p-value |Assessment
    #=============================================================================#
    diehard_birthdays|   0|       100|     100|0.17512489|  PASSED  
        diehard_operm5|   0|   1000000|     100|0.78131123|  PASSED  
    diehard_rank_32x32|   0|     40000|     100|0.72911985|  PASSED  
        diehard_rank_6x8|   0|    100000|     100|0.99242735|  PASSED  
    diehard_bitstream|   0|   2097152|     100|0.26891434|  PASSED  
            diehard_opso|   0|   2097152|     100|0.82145169|  PASSED  
            diehard_oqso|   0|   2097152|     100|0.59562510|  PASSED  
            diehard_dna|   0|   2097152|     100|0.73161723|  PASSED  
    diehard_count_1s_str|   0|    256000|     100|0.17618601|  PASSED  
    diehard_count_1s_byt|   0|    256000|     100|0.99849141|   WEAK   
    diehard_parking_lot|   0|     12000|     100|0.30644186|  PASSED  
        diehard_2dsphere|   2|      8000|     100|0.58156608|  PASSED  
        diehard_3dsphere|   3|      4000|     100|0.89765731|  PASSED  
        diehard_squeeze|   0|    100000|     100|0.54776153|  PASSED  
            diehard_sums|   0|       100|     100|0.29377652|  PASSED  
            diehard_runs|   0|    100000|     100|0.42753914|  PASSED  
            diehard_runs|   0|    100000|     100|0.90025548|  PASSED  
        diehard_craps|   0|    200000|     100|0.10521559|  PASSED  
        diehard_craps|   0|    200000|     100|0.20258865|  PASSED  
    marsaglia_tsang_gcd|   0|  10000000|     100|0.38511266|  PASSED  
    marsaglia_tsang_gcd|   0|  10000000|     100|0.10590465|  PASSED  
            sts_monobit|   1|    100000|     100|0.50151635|  PASSED  
                sts_runs|   2|    100000|     100|0.34254051|  PASSED  
            sts_serial|   1|    100000|     100|0.99759110|   WEAK   
            sts_serial|   2|    100000|     100|0.55904630|  PASSED  
            sts_serial|   3|    100000|     100|0.79476700|  PASSED  
            sts_serial|   3|    100000|     100|0.47882475|  PASSED  
            sts_serial|   4|    100000|     100|0.25505236|  PASSED  
            sts_serial|   4|    100000|     100|0.21574238|  PASSED  
            sts_serial|   5|    100000|     100|0.84799273|  PASSED  
            sts_serial|   5|    100000|     100|0.97432553|  PASSED  
            sts_serial|   6|    100000|     100|0.78630490|  PASSED  
            sts_serial|   6|    100000|     100|0.61707307|  PASSED  
            sts_serial|   7|    100000|     100|0.28628559|  PASSED  
            sts_serial|   7|    100000|     100|0.06334365|  PASSED  
            sts_serial|   8|    100000|     100|0.58461987|  PASSED  
            sts_serial|   8|    100000|     100|0.83317120|  PASSED  
            sts_serial|   9|    100000|     100|0.93926975|  PASSED  
            sts_serial|   9|    100000|     100|0.93259961|  PASSED  
            sts_serial|  10|    100000|     100|0.35310568|  PASSED  
            sts_serial|  10|    100000|     100|0.95929065|  PASSED  
            sts_serial|  11|    100000|     100|0.99388673|  PASSED  
            sts_serial|  11|    100000|     100|0.53123685|  PASSED  
            sts_serial|  12|    100000|     100|0.96962573|  PASSED  
            sts_serial|  12|    100000|     100|0.41339669|  PASSED  
            sts_serial|  13|    100000|     100|0.28615070|  PASSED  
            sts_serial|  13|    100000|     100|0.37531434|  PASSED  
            sts_serial|  14|    100000|     100|0.00134377|   WEAK   
            sts_serial|  14|    100000|     100|0.00476989|   WEAK   
            sts_serial|  15|    100000|     100|0.31119360|  PASSED  
            sts_serial|  15|    100000|     100|0.94938707|  PASSED  
            sts_serial|  16|    100000|     100|0.15394246|  PASSED  
            sts_serial|  16|    100000|     100|0.83217236|  PASSED  
            rgb_bitdist|   1|    100000|     100|0.90950362|  PASSED  
            rgb_bitdist|   2|    100000|     100|0.71123670|  PASSED  
            rgb_bitdist|   3|    100000|     100|0.93908232|  PASSED  
            rgb_bitdist|   4|    100000|     100|0.03284561|  PASSED  
            rgb_bitdist|   5|    100000|     100|0.92102909|  PASSED  
            rgb_bitdist|   6|    100000|     100|0.17865806|  PASSED  
            rgb_bitdist|   7|    100000|     100|0.74543852|  PASSED  
            rgb_bitdist|   8|    100000|     100|0.34206487|  PASSED  
            rgb_bitdist|   9|    100000|     100|0.87229687|  PASSED  
            rgb_bitdist|  10|    100000|     100|0.72030829|  PASSED  
            rgb_bitdist|  11|    100000|     100|0.74299542|  PASSED  
            rgb_bitdist|  12|    100000|     100|0.99482517|  PASSED  
    rgb_minimum_distance|   2|     10000|    1000|0.24236609|  PASSED  
    rgb_minimum_distance|   3|     10000|    1000|0.16740735|  PASSED  
    rgb_minimum_distance|   4|     10000|    1000|0.70898779|  PASSED  
    rgb_minimum_distance|   5|     10000|    1000|0.96857742|  PASSED  
        rgb_permutations|   2|    100000|     100|0.19195953|  PASSED  
        rgb_permutations|   3|    100000|     100|0.99904725|   WEAK   
        rgb_permutations|   4|    100000|     100|0.58834005|  PASSED  
        rgb_permutations|   5|    100000|     100|0.34484295|  PASSED  
        rgb_lagged_sum|   0|   1000000|     100|0.96471156|  PASSED  
        rgb_lagged_sum|   1|   1000000|     100|0.07693983|  PASSED  
        rgb_lagged_sum|   2|   1000000|     100|0.90432746|  PASSED  
        rgb_lagged_sum|   3|   1000000|     100|0.02360196|  PASSED  
        rgb_lagged_sum|   4|   1000000|     100|0.16193850|  PASSED  
        rgb_lagged_sum|   5|   1000000|     100|0.98582346|  PASSED  
        rgb_lagged_sum|   6|   1000000|     100|0.22129636|  PASSED  
        rgb_lagged_sum|   7|   1000000|     100|0.17352367|  PASSED  
        rgb_lagged_sum|   8|   1000000|     100|0.98205801|  PASSED  
        rgb_lagged_sum|   9|   1000000|     100|0.66525265|  PASSED  
        rgb_lagged_sum|  10|   1000000|     100|0.29857498|  PASSED  
        rgb_lagged_sum|  11|   1000000|     100|0.68191698|  PASSED  
        rgb_lagged_sum|  12|   1000000|     100|0.73878756|  PASSED  
        rgb_lagged_sum|  13|   1000000|     100|0.85472715|  PASSED  
        rgb_lagged_sum|  14|   1000000|     100|0.45389726|  PASSED  
        rgb_lagged_sum|  15|   1000000|     100|0.21739954|  PASSED  
        rgb_lagged_sum|  16|   1000000|     100|0.71508849|  PASSED  
        rgb_lagged_sum|  17|   1000000|     100|0.69646382|  PASSED  
        rgb_lagged_sum|  18|   1000000|     100|0.01571233|  PASSED  
        rgb_lagged_sum|  19|   1000000|     100|0.98589714|  PASSED  
        rgb_lagged_sum|  20|   1000000|     100|0.28941217|  PASSED  
        rgb_lagged_sum|  21|   1000000|     100|0.58943843|  PASSED  
        rgb_lagged_sum|  22|   1000000|     100|0.22737828|  PASSED  
        rgb_lagged_sum|  23|   1000000|     100|0.40550298|  PASSED  
        rgb_lagged_sum|  24|   1000000|     100|0.30454073|  PASSED  
        rgb_lagged_sum|  25|   1000000|     100|0.99537377|   WEAK   
        rgb_lagged_sum|  26|   1000000|     100|0.60856419|  PASSED  
        rgb_lagged_sum|  27|   1000000|     100|0.59270370|  PASSED  
        rgb_lagged_sum|  28|   1000000|     100|0.73125878|  PASSED  
        rgb_lagged_sum|  29|   1000000|     100|0.13433842|  PASSED  
        rgb_lagged_sum|  30|   1000000|     100|0.63765603|  PASSED  
        rgb_lagged_sum|  31|   1000000|     100|0.95549510|  PASSED  
        rgb_lagged_sum|  32|   1000000|     100|0.47652287|  PASSED  
        rgb_kstest_test|   0|     10000|    1000|0.81342082|  PASSED  
        dab_bytedistrib|   0|  51200000|       1|0.95643504|  PASSED  
                dab_dct| 256|     50000|       1|0.19477010|  PASSED  
    Preparing to run test 207.  ntuple = 0
            dab_filltree|  32|  15000000|       1|0.36806496|  PASSED  
            dab_filltree|  32|  15000000|       1|0.64082566|  PASSED  
    Preparing to run test 208.  ntuple = 0
        dab_filltree2|   0|   5000000|       1|0.38972249|  PASSED  
        dab_filltree2|   1|   5000000|       1|0.16454331|  PASSED  
    Preparing to run test 209.  ntuple = 0
            dab_monobit2|  12|  65000000|       1|0.99790983|   WEAK   
    #=============================================================================#
    # Summary: PASSED=107, WEAK=7, FAILED=0                                       #
    #          235,031.336 MB of random data created with 150.019 MB/sec          #
    #=============================================================================#
    #=============================================================================#
    # Runtime: 0:26:06                                                            #
    #=============================================================================#
    
## NanoTimeRandom    
    
    #=============================================================================#
    # Testing: io.jenetics.prngine.internal.NanoTimeRandom (2017-03-03 01:26)     #
    #=============================================================================#
    #=============================================================================#
    # Linux 4.8.0-40-generic (amd64)                                              #
    # java version "1.8.0_112"                                                    #
    # Java(TM) SE Runtime Environment (build 1.8.0_112-b15)                       #
    # Java HotSpot(TM) 64-Bit Server VM (build 25.112-b15)                        #
    #=============================================================================#
    #=============================================================================#
    #            dieharder version 3.31.1 Copyright 2003 Robert G. Brown          #
    #=============================================================================#
    rng_name    |rands/second|   Seed   |
    stdin_input_raw|  6.36e+07  |3774154151|
    #=============================================================================#
            test_name   |ntup| tsamples |psamples|  p-value |Assessment
    #=============================================================================#
    diehard_birthdays|   0|       100|     100|0.00000000|  FAILED  
        diehard_operm5|   0|   1000000|     100|0.00000000|  FAILED  
    diehard_rank_32x32|   0|     40000|     100|0.00000000|  FAILED  
        diehard_rank_6x8|   0|    100000|     100|0.00000000|  FAILED  
    diehard_bitstream|   0|   2097152|     100|0.00000000|  FAILED  
            diehard_opso|   0|   2097152|     100|0.00000000|  FAILED  
            diehard_oqso|   0|   2097152|     100|0.00000000|  FAILED  
            diehard_dna|   0|   2097152|     100|0.00000000|  FAILED  
    diehard_count_1s_str|   0|    256000|     100|0.00000000|  FAILED  
    diehard_count_1s_byt|   0|    256000|     100|0.00000000|  FAILED  
    diehard_parking_lot|   0|     12000|     100|0.00000000|  FAILED  
        diehard_2dsphere|   2|      8000|     100|0.00000000|  FAILED  
        diehard_3dsphere|   3|      4000|     100|0.00000000|  FAILED  
        diehard_squeeze|   0|    100000|     100|0.00000000|  FAILED  
            diehard_sums|   0|       100|     100|0.00000000|  FAILED  
            diehard_runs|   0|    100000|     100|0.00000000|  FAILED  
            diehard_runs|   0|    100000|     100|0.00000000|  FAILED  
        diehard_craps|   0|    200000|     100|0.00000000|  FAILED  
        diehard_craps|   0|    200000|     100|0.00000000|  FAILED  
    marsaglia_tsang_gcd|   0|  10000000|     100|0.00000000|  FAILED  
    marsaglia_tsang_gcd|   0|  10000000|     100|0.00000000|  FAILED  
            sts_monobit|   1|    100000|     100|0.00000000|  FAILED  
                sts_runs|   2|    100000|     100|0.00000000|  FAILED  
            sts_serial|   1|    100000|     100|0.00000000|  FAILED  
            sts_serial|   2|    100000|     100|0.00000000|  FAILED  
            sts_serial|   3|    100000|     100|0.00000000|  FAILED  
            sts_serial|   3|    100000|     100|0.00000000|  FAILED  
            sts_serial|   4|    100000|     100|0.00000000|  FAILED  
            sts_serial|   4|    100000|     100|0.00000000|  FAILED  
            sts_serial|   5|    100000|     100|0.00000000|  FAILED  
            sts_serial|   5|    100000|     100|0.00000000|  FAILED  
            sts_serial|   6|    100000|     100|0.00000000|  FAILED  
            sts_serial|   6|    100000|     100|0.00000000|  FAILED  
            sts_serial|   7|    100000|     100|0.00000000|  FAILED  
            sts_serial|   7|    100000|     100|0.00000000|  FAILED  
            sts_serial|   8|    100000|     100|0.00000000|  FAILED  
            sts_serial|   8|    100000|     100|0.00000000|  FAILED  
            sts_serial|   9|    100000|     100|0.00000000|  FAILED  
            sts_serial|   9|    100000|     100|0.00000000|  FAILED  
            sts_serial|  10|    100000|     100|0.00000000|  FAILED  
            sts_serial|  10|    100000|     100|0.00000000|  FAILED  
            sts_serial|  11|    100000|     100|0.00000000|  FAILED  
            sts_serial|  11|    100000|     100|0.00000000|  FAILED  
            sts_serial|  12|    100000|     100|0.00000000|  FAILED  
            sts_serial|  12|    100000|     100|0.00000000|  FAILED  
            sts_serial|  13|    100000|     100|0.00000000|  FAILED  
            sts_serial|  13|    100000|     100|0.00000000|  FAILED  
            sts_serial|  14|    100000|     100|0.00000000|  FAILED  
            sts_serial|  14|    100000|     100|0.00000000|  FAILED  
            sts_serial|  15|    100000|     100|0.00000000|  FAILED  
            sts_serial|  15|    100000|     100|0.00000000|  FAILED  
            sts_serial|  16|    100000|     100|0.00000000|  FAILED  
            sts_serial|  16|    100000|     100|0.00000000|  FAILED  
            rgb_bitdist|   1|    100000|     100|0.00000000|  FAILED  
            rgb_bitdist|   2|    100000|     100|0.00000000|  FAILED  
            rgb_bitdist|   3|    100000|     100|0.00000000|  FAILED  
            rgb_bitdist|   4|    100000|     100|0.00000000|  FAILED  
            rgb_bitdist|   5|    100000|     100|0.00000000|  FAILED  
            rgb_bitdist|   6|    100000|     100|0.00000000|  FAILED  
            rgb_bitdist|   7|    100000|     100|0.00000000|  FAILED  
            rgb_bitdist|   8|    100000|     100|0.00000000|  FAILED  
            rgb_bitdist|   9|    100000|     100|0.00000000|  FAILED  
            rgb_bitdist|  10|    100000|     100|0.00000000|  FAILED  
            rgb_bitdist|  11|    100000|     100|0.00000000|  FAILED  
            rgb_bitdist|  12|    100000|     100|0.00000000|  FAILED  
    rgb_minimum_distance|   2|     10000|    1000|0.00000000|  FAILED  
    rgb_minimum_distance|   3|     10000|    1000|0.00000000|  FAILED  
    rgb_minimum_distance|   4|     10000|    1000|0.00000000|  FAILED  
    rgb_minimum_distance|   5|     10000|    1000|0.00000000|  FAILED  
        rgb_permutations|   2|    100000|     100|0.00000000|  FAILED  
        rgb_permutations|   3|    100000|     100|0.00000000|  FAILED  
        rgb_permutations|   4|    100000|     100|0.00000000|  FAILED  
        rgb_permutations|   5|    100000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|   0|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|   1|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|   2|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|   3|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|   4|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|   5|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|   6|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|   7|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|   8|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|   9|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  10|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  11|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  12|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  13|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  14|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  15|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  16|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  17|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  18|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  19|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  20|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  21|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  22|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  23|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  24|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  25|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  26|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  27|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  28|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  29|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  30|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  31|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  32|   1000000|     100|0.00000000|  FAILED  
        rgb_kstest_test|   0|     10000|    1000|0.00000000|  FAILED  
        dab_bytedistrib|   0|  51200000|       1|0.00000000|  FAILED  
                dab_dct| 256|     50000|       1|0.00000000|  FAILED  
    Preparing to run test 207.  ntuple = 0
            dab_filltree|  32|  15000000|       1|0.00000000|  FAILED  
            dab_filltree|  32|  15000000|       1|0.00000000|  FAILED  
    Preparing to run test 208.  ntuple = 0
        dab_filltree2|   0|   5000000|       1|0.00000000|  FAILED  
        dab_filltree2|   1|   5000000|       1|0.00000000|  FAILED  
    Preparing to run test 209.  ntuple = 0
            dab_monobit2|  12|  65000000|       1|1.00000000|  FAILED  
    #=============================================================================#
    # Summary: PASSED=0, WEAK=0, FAILED=114                                       #
    #          234,011.508 MB of random data created with 68.494 MB/sec           #
    #=============================================================================#
    #=============================================================================#
    # Runtime: 0:56:56                                                            #
    #=============================================================================#
    
## ObjectHashRandom    
    
    #=============================================================================#
    # Testing: io.jenetics.prngine.internal.ObjectHashRandom (2017-03-03 02:23)   #
    #=============================================================================#
    #=============================================================================#
    # Linux 4.8.0-40-generic (amd64)                                              #
    # java version "1.8.0_112"                                                    #
    # Java(TM) SE Runtime Environment (build 1.8.0_112-b15)                       #
    # Java HotSpot(TM) 64-Bit Server VM (build 25.112-b15)                        #
    #=============================================================================#
    #=============================================================================#
    #            dieharder version 3.31.1 Copyright 2003 Robert G. Brown          #
    #=============================================================================#
    rng_name    |rands/second|   Seed   |
    stdin_input_raw|  2.37e+07  |  37135072|
    #=============================================================================#
            test_name   |ntup| tsamples |psamples|  p-value |Assessment
    #=============================================================================#
    diehard_birthdays|   0|       100|     100|0.76290408|  PASSED  
        diehard_operm5|   0|   1000000|     100|0.60551289|  PASSED  
    diehard_rank_32x32|   0|     40000|     100|0.00000000|  FAILED  
        diehard_rank_6x8|   0|    100000|     100|0.28065701|  PASSED  
    diehard_bitstream|   0|   2097152|     100|0.00000000|  FAILED  
            diehard_opso|   0|   2097152|     100|0.04182323|  PASSED  
            diehard_oqso|   0|   2097152|     100|0.90022964|  PASSED  
            diehard_dna|   0|   2097152|     100|0.00000000|  FAILED  
    diehard_count_1s_str|   0|    256000|     100|0.00000000|  FAILED  
    diehard_count_1s_byt|   0|    256000|     100|0.00000000|  FAILED  
    diehard_parking_lot|   0|     12000|     100|0.00000000|  FAILED  
        diehard_2dsphere|   2|      8000|     100|0.00000000|  FAILED  
        diehard_3dsphere|   3|      4000|     100|0.00000000|  FAILED  
        diehard_squeeze|   0|    100000|     100|0.00000000|  FAILED  
            diehard_sums|   0|       100|     100|0.00000000|  FAILED  
            diehard_runs|   0|    100000|     100|0.06878659|  PASSED  
            diehard_runs|   0|    100000|     100|0.59930805|  PASSED  
        diehard_craps|   0|    200000|     100|0.00000000|  FAILED  
        diehard_craps|   0|    200000|     100|0.00000000|  FAILED  
    marsaglia_tsang_gcd|   0|  10000000|     100|0.00000000|  FAILED  
    marsaglia_tsang_gcd|   0|  10000000|     100|0.18943916|  PASSED  
            sts_monobit|   1|    100000|     100|0.00000000|  FAILED  
                sts_runs|   2|    100000|     100|0.00000000|  FAILED  
            sts_serial|   1|    100000|     100|0.00000000|  FAILED  
            sts_serial|   2|    100000|     100|0.00000000|  FAILED  
            sts_serial|   3|    100000|     100|0.00000000|  FAILED  
            sts_serial|   3|    100000|     100|0.95999522|  PASSED  
            sts_serial|   4|    100000|     100|0.00000000|  FAILED  
            sts_serial|   4|    100000|     100|0.26178675|  PASSED  
            sts_serial|   5|    100000|     100|0.00000000|  FAILED  
            sts_serial|   5|    100000|     100|0.87233306|  PASSED  
            sts_serial|   6|    100000|     100|0.00000000|  FAILED  
            sts_serial|   6|    100000|     100|0.98551082|  PASSED  
            sts_serial|   7|    100000|     100|0.00000000|  FAILED  
            sts_serial|   7|    100000|     100|0.43253610|  PASSED  
            sts_serial|   8|    100000|     100|0.00000000|  FAILED  
            sts_serial|   8|    100000|     100|0.13145682|  PASSED  
            sts_serial|   9|    100000|     100|0.00000000|  FAILED  
            sts_serial|   9|    100000|     100|0.35892706|  PASSED  
            sts_serial|  10|    100000|     100|0.00000000|  FAILED  
            sts_serial|  10|    100000|     100|0.21327351|  PASSED  
            sts_serial|  11|    100000|     100|0.00000000|  FAILED  
            sts_serial|  11|    100000|     100|0.15287650|  PASSED  
            sts_serial|  12|    100000|     100|0.00000000|  FAILED  
            sts_serial|  12|    100000|     100|0.53955683|  PASSED  
            sts_serial|  13|    100000|     100|0.00000000|  FAILED  
            sts_serial|  13|    100000|     100|0.83742508|  PASSED  
            sts_serial|  14|    100000|     100|0.00000000|  FAILED  
            sts_serial|  14|    100000|     100|0.33667462|  PASSED  
            sts_serial|  15|    100000|     100|0.00000000|  FAILED  
            sts_serial|  15|    100000|     100|0.21037352|  PASSED  
            sts_serial|  16|    100000|     100|0.00000000|  FAILED  
            sts_serial|  16|    100000|     100|0.61982184|  PASSED  
            rgb_bitdist|   1|    100000|     100|0.00000000|  FAILED  
            rgb_bitdist|   2|    100000|     100|0.00000000|  FAILED  
            rgb_bitdist|   3|    100000|     100|0.00000000|  FAILED  
            rgb_bitdist|   4|    100000|     100|0.00000000|  FAILED  
            rgb_bitdist|   5|    100000|     100|0.00000000|  FAILED  
            rgb_bitdist|   6|    100000|     100|0.00000000|  FAILED  
            rgb_bitdist|   7|    100000|     100|0.00000000|  FAILED  
            rgb_bitdist|   8|    100000|     100|0.00000000|  FAILED  
            rgb_bitdist|   9|    100000|     100|0.00000000|  FAILED  
            rgb_bitdist|  10|    100000|     100|0.00000000|  FAILED  
            rgb_bitdist|  11|    100000|     100|0.00000000|  FAILED  
            rgb_bitdist|  12|    100000|     100|0.00000000|  FAILED  
    rgb_minimum_distance|   2|     10000|    1000|0.00000000|  FAILED  
    rgb_minimum_distance|   3|     10000|    1000|0.00000000|  FAILED  
    rgb_minimum_distance|   4|     10000|    1000|0.00000000|  FAILED  
    rgb_minimum_distance|   5|     10000|    1000|0.00000000|  FAILED  
        rgb_permutations|   2|    100000|     100|0.91719366|  PASSED  
        rgb_permutations|   3|    100000|     100|0.89536099|  PASSED  
        rgb_permutations|   4|    100000|     100|0.45245209|  PASSED  
        rgb_permutations|   5|    100000|     100|0.98806221|  PASSED  
        rgb_lagged_sum|   0|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|   1|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|   2|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|   3|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|   4|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|   5|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|   6|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|   7|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|   8|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|   9|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  10|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  11|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  12|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  13|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  14|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  15|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  16|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  17|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  18|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  19|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  20|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  21|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  22|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  23|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  24|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  25|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  26|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  27|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  28|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  29|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  30|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  31|   1000000|     100|0.00000000|  FAILED  
        rgb_lagged_sum|  32|   1000000|     100|0.00000000|  FAILED  
        rgb_kstest_test|   0|     10000|    1000|0.00000000|  FAILED  
        dab_bytedistrib|   0|  51200000|       1|0.00000000|  FAILED  
                dab_dct| 256|     50000|       1|0.00000000|  FAILED  
    Preparing to run test 207.  ntuple = 0
            dab_filltree|  32|  15000000|       1|0.30773420|  PASSED  
            dab_filltree|  32|  15000000|       1|0.90771712|  PASSED  
    Preparing to run test 208.  ntuple = 0
        dab_filltree2|   0|   5000000|       1|0.00000000|  FAILED  
        dab_filltree2|   1|   5000000|       1|0.00000000|  FAILED  
    Preparing to run test 209.  ntuple = 0
            dab_monobit2|  12|  65000000|       1|1.00000000|  FAILED  
    #=============================================================================#
    # Summary: PASSED=28, WEAK=0, FAILED=86                                       #
    #          234,759.852 MB of random data created with 57.421 MB/sec           #
    #=============================================================================#
    #=============================================================================#
    # Runtime: 1:08:08                                                            #
    #=============================================================================#
    
## SeedRandom    
    
    #=============================================================================#
    # Testing: io.jenetics.prngine.internal.SeedRandom (2017-03-03 03:31)         #
    #=============================================================================#
    #=============================================================================#
    # Linux 4.8.0-40-generic (amd64)                                              #
    # java version "1.8.0_112"                                                    #
    # Java(TM) SE Runtime Environment (build 1.8.0_112-b15)                       #
    # Java HotSpot(TM) 64-Bit Server VM (build 25.112-b15)                        #
    #=============================================================================#
    #=============================================================================#
    #            dieharder version 3.31.1 Copyright 2003 Robert G. Brown          #
    #=============================================================================#
    rng_name    |rands/second|   Seed   |
    stdin_input_raw|  1.80e+07  |3661220842|
    #=============================================================================#
            test_name   |ntup| tsamples |psamples|  p-value |Assessment
    #=============================================================================#
    diehard_birthdays|   0|       100|     100|0.80879726|  PASSED  
        diehard_operm5|   0|   1000000|     100|0.89784192|  PASSED  
    diehard_rank_32x32|   0|     40000|     100|0.49876303|  PASSED  
        diehard_rank_6x8|   0|    100000|     100|0.48695002|  PASSED  
    diehard_bitstream|   0|   2097152|     100|0.91012903|  PASSED  
            diehard_opso|   0|   2097152|     100|0.79515040|  PASSED  
            diehard_oqso|   0|   2097152|     100|0.11317405|  PASSED  
            diehard_dna|   0|   2097152|     100|0.91310284|  PASSED  
    diehard_count_1s_str|   0|    256000|     100|0.82656457|  PASSED  
    diehard_count_1s_byt|   0|    256000|     100|0.29456352|  PASSED  
    diehard_parking_lot|   0|     12000|     100|0.18103491|  PASSED  
        diehard_2dsphere|   2|      8000|     100|0.72159911|  PASSED  
        diehard_3dsphere|   3|      4000|     100|0.25239274|  PASSED  
        diehard_squeeze|   0|    100000|     100|0.32910035|  PASSED  
            diehard_sums|   0|       100|     100|0.01507325|  PASSED  
            diehard_runs|   0|    100000|     100|0.02632514|  PASSED  
            diehard_runs|   0|    100000|     100|0.43060182|  PASSED  
        diehard_craps|   0|    200000|     100|0.91561498|  PASSED  
        diehard_craps|   0|    200000|     100|0.97896092|  PASSED  
    marsaglia_tsang_gcd|   0|  10000000|     100|0.74475043|  PASSED  
    marsaglia_tsang_gcd|   0|  10000000|     100|0.45297002|  PASSED  
            sts_monobit|   1|    100000|     100|0.31805718|  PASSED  
                sts_runs|   2|    100000|     100|0.09857592|  PASSED  
            sts_serial|   1|    100000|     100|0.41813564|  PASSED  
            sts_serial|   2|    100000|     100|0.09278960|  PASSED  
            sts_serial|   3|    100000|     100|0.84946003|  PASSED  
            sts_serial|   3|    100000|     100|0.52498822|  PASSED  
            sts_serial|   4|    100000|     100|0.98277134|  PASSED  
            sts_serial|   4|    100000|     100|0.55918531|  PASSED  
            sts_serial|   5|    100000|     100|0.41062514|  PASSED  
            sts_serial|   5|    100000|     100|0.62648261|  PASSED  
            sts_serial|   6|    100000|     100|0.99990141|   WEAK   
            sts_serial|   6|    100000|     100|0.23034072|  PASSED  
            sts_serial|   7|    100000|     100|0.56432143|  PASSED  
            sts_serial|   7|    100000|     100|0.27724453|  PASSED  
            sts_serial|   8|    100000|     100|0.96206177|  PASSED  
            sts_serial|   8|    100000|     100|0.25201884|  PASSED  
            sts_serial|   9|    100000|     100|0.31763486|  PASSED  
            sts_serial|   9|    100000|     100|0.65675980|  PASSED  
            sts_serial|  10|    100000|     100|0.20445493|  PASSED  
            sts_serial|  10|    100000|     100|0.76179233|  PASSED  
            sts_serial|  11|    100000|     100|0.33778473|  PASSED  
            sts_serial|  11|    100000|     100|0.80606360|  PASSED  
            sts_serial|  12|    100000|     100|0.97301278|  PASSED  
            sts_serial|  12|    100000|     100|0.88124186|  PASSED  
            sts_serial|  13|    100000|     100|0.98994846|  PASSED  
            sts_serial|  13|    100000|     100|0.61561347|  PASSED  
            sts_serial|  14|    100000|     100|0.23008969|  PASSED  
            sts_serial|  14|    100000|     100|0.48920599|  PASSED  
            sts_serial|  15|    100000|     100|0.25556506|  PASSED  
            sts_serial|  15|    100000|     100|0.49892223|  PASSED  
            sts_serial|  16|    100000|     100|0.08158279|  PASSED  
            sts_serial|  16|    100000|     100|0.78161338|  PASSED  
            rgb_bitdist|   1|    100000|     100|0.98865357|  PASSED  
            rgb_bitdist|   2|    100000|     100|0.13505094|  PASSED  
            rgb_bitdist|   3|    100000|     100|0.99999957|  FAILED  
            rgb_bitdist|   4|    100000|     100|0.95045654|  PASSED  
            rgb_bitdist|   5|    100000|     100|0.69844729|  PASSED  
            rgb_bitdist|   6|    100000|     100|0.82276440|  PASSED  
            rgb_bitdist|   7|    100000|     100|0.46754009|  PASSED  
            rgb_bitdist|   8|    100000|     100|0.93100123|  PASSED  
            rgb_bitdist|   9|    100000|     100|0.97547356|  PASSED  
            rgb_bitdist|  10|    100000|     100|0.73062085|  PASSED  
            rgb_bitdist|  11|    100000|     100|0.26207725|  PASSED  
            rgb_bitdist|  12|    100000|     100|0.48499464|  PASSED  
    rgb_minimum_distance|   2|     10000|    1000|0.78328676|  PASSED  
    rgb_minimum_distance|   3|     10000|    1000|0.29126221|  PASSED  
    rgb_minimum_distance|   4|     10000|    1000|0.93349270|  PASSED  
    rgb_minimum_distance|   5|     10000|    1000|0.25989540|  PASSED  
        rgb_permutations|   2|    100000|     100|0.46473861|  PASSED  
        rgb_permutations|   3|    100000|     100|0.65782817|  PASSED  
        rgb_permutations|   4|    100000|     100|0.94121241|  PASSED  
        rgb_permutations|   5|    100000|     100|0.97894487|  PASSED  
        rgb_lagged_sum|   0|   1000000|     100|0.98450107|  PASSED  
        rgb_lagged_sum|   1|   1000000|     100|0.36927158|  PASSED  
        rgb_lagged_sum|   2|   1000000|     100|0.05097375|  PASSED  
        rgb_lagged_sum|   3|   1000000|     100|0.67696472|  PASSED  
        rgb_lagged_sum|   4|   1000000|     100|0.63500537|  PASSED  
        rgb_lagged_sum|   5|   1000000|     100|0.91812256|  PASSED  
        rgb_lagged_sum|   6|   1000000|     100|0.76884401|  PASSED  
        rgb_lagged_sum|   7|   1000000|     100|0.79205773|  PASSED  
        rgb_lagged_sum|   8|   1000000|     100|0.36462610|  PASSED  
        rgb_lagged_sum|   9|   1000000|     100|0.30351732|  PASSED  
        rgb_lagged_sum|  10|   1000000|     100|0.85349654|  PASSED  
        rgb_lagged_sum|  11|   1000000|     100|0.23733566|  PASSED  
        rgb_lagged_sum|  12|   1000000|     100|0.12759286|  PASSED  
        rgb_lagged_sum|  13|   1000000|     100|0.70889661|  PASSED  
        rgb_lagged_sum|  14|   1000000|     100|0.05180929|  PASSED  
        rgb_lagged_sum|  15|   1000000|     100|0.33186904|  PASSED  
        rgb_lagged_sum|  16|   1000000|     100|0.71239135|  PASSED  
        rgb_lagged_sum|  17|   1000000|     100|0.71022467|  PASSED  
        rgb_lagged_sum|  18|   1000000|     100|0.92672056|  PASSED  
        rgb_lagged_sum|  19|   1000000|     100|0.17650208|  PASSED  
        rgb_lagged_sum|  20|   1000000|     100|0.22011306|  PASSED  
        rgb_lagged_sum|  21|   1000000|     100|0.60450414|  PASSED  
        rgb_lagged_sum|  22|   1000000|     100|0.90933189|  PASSED  
        rgb_lagged_sum|  23|   1000000|     100|0.65556895|  PASSED  
        rgb_lagged_sum|  24|   1000000|     100|0.58149509|  PASSED  
        rgb_lagged_sum|  25|   1000000|     100|0.74465075|  PASSED  
        rgb_lagged_sum|  26|   1000000|     100|0.83450810|  PASSED  
        rgb_lagged_sum|  27|   1000000|     100|0.28469222|  PASSED  
        rgb_lagged_sum|  28|   1000000|     100|0.89287884|  PASSED  
        rgb_lagged_sum|  29|   1000000|     100|0.68278352|  PASSED  
        rgb_lagged_sum|  30|   1000000|     100|0.84390304|  PASSED  
        rgb_lagged_sum|  31|   1000000|     100|0.99676822|   WEAK   
        rgb_lagged_sum|  32|   1000000|     100|0.27832571|  PASSED  
        rgb_kstest_test|   0|     10000|    1000|0.81679024|  PASSED  
        dab_bytedistrib|   0|  51200000|       1|0.84647886|  PASSED  
                dab_dct| 256|     50000|       1|0.10758683|  PASSED  
    Preparing to run test 207.  ntuple = 0
            dab_filltree|  32|  15000000|       1|0.17345638|  PASSED  
            dab_filltree|  32|  15000000|       1|0.40697045|  PASSED  
    Preparing to run test 208.  ntuple = 0
        dab_filltree2|   0|   5000000|       1|0.08049150|  PASSED  
        dab_filltree2|   1|   5000000|       1|0.22583776|  PASSED  
    Preparing to run test 209.  ntuple = 0
            dab_monobit2|  12|  65000000|       1|0.88057640|  PASSED  
    #=============================================================================#
    # Summary: PASSED=111, WEAK=2, FAILED=1                                       #
    #          235,031.336 MB of random data created with 53.069 MB/sec           #
    #=============================================================================#
    #=============================================================================#
    # Runtime: 1:13:48                                                            #
    #=============================================================================#
    
## java.util.Random
    
    #=============================================================================#
    # Testing: java.util.Random (2017-03-04 14:16)                                #
    #=============================================================================#
    #=============================================================================#
    # Linux 4.8.0-40-generic (amd64)                                              #
    # java version "1.8.0_112"                                                    #
    # Java(TM) SE Runtime Environment (build 1.8.0_112-b15)                       #
    # Java HotSpot(TM) 64-Bit Server VM (build 25.112-b15)                        #
    #=============================================================================#
    #=============================================================================#
    #            dieharder version 3.31.1 Copyright 2003 Robert G. Brown          #
    #=============================================================================#
       rng_name    |rands/second|   Seed   |
    stdin_input_raw|  5.50e+07  | 868805523|
    #=============================================================================#
            test_name   |ntup| tsamples |psamples|  p-value |Assessment
    #=============================================================================#
       diehard_birthdays|   0|       100|     100|0.39815532|  PASSED  
          diehard_operm5|   0|   1000000|     100|0.61419442|  PASSED  
      diehard_rank_32x32|   0|     40000|     100|0.97617429|  PASSED  
        diehard_rank_6x8|   0|    100000|     100|0.54987273|  PASSED  
       diehard_bitstream|   0|   2097152|     100|0.99883349|   WEAK   
            diehard_opso|   0|   2097152|     100|0.00000000|  FAILED  
            diehard_oqso|   0|   2097152|     100|0.00000000|  FAILED  
             diehard_dna|   0|   2097152|     100|0.00000000|  FAILED  
    diehard_count_1s_str|   0|    256000|     100|0.17889327|  PASSED  
    diehard_count_1s_byt|   0|    256000|     100|0.60179788|  PASSED  
     diehard_parking_lot|   0|     12000|     100|0.99280463|  PASSED  
        diehard_2dsphere|   2|      8000|     100|0.98218004|  PASSED  
        diehard_3dsphere|   3|      4000|     100|0.01026362|  PASSED  
         diehard_squeeze|   0|    100000|     100|0.76704721|  PASSED  
            diehard_sums|   0|       100|     100|0.00001129|   WEAK   
            diehard_runs|   0|    100000|     100|0.97957522|  PASSED  
            diehard_runs|   0|    100000|     100|0.50161642|  PASSED  
           diehard_craps|   0|    200000|     100|0.36926714|  PASSED  
           diehard_craps|   0|    200000|     100|0.21010802|  PASSED  
     marsaglia_tsang_gcd|   0|  10000000|     100|0.82103693|  PASSED  
     marsaglia_tsang_gcd|   0|  10000000|     100|0.00004809|   WEAK   
             sts_monobit|   1|    100000|     100|0.20139319|  PASSED  
                sts_runs|   2|    100000|     100|0.26815873|  PASSED  
              sts_serial|   1|    100000|     100|0.42695694|  PASSED  
              sts_serial|   2|    100000|     100|0.54566638|  PASSED  
              sts_serial|   3|    100000|     100|0.83808864|  PASSED  
              sts_serial|   3|    100000|     100|0.26319415|  PASSED  
              sts_serial|   4|    100000|     100|0.57267139|  PASSED  
              sts_serial|   4|    100000|     100|0.50395247|  PASSED  
              sts_serial|   5|    100000|     100|0.39838386|  PASSED  
              sts_serial|   5|    100000|     100|0.46153924|  PASSED  
              sts_serial|   6|    100000|     100|0.62897198|  PASSED  
              sts_serial|   6|    100000|     100|0.57767817|  PASSED  
              sts_serial|   7|    100000|     100|0.50520336|  PASSED  
              sts_serial|   7|    100000|     100|0.27382811|  PASSED  
              sts_serial|   8|    100000|     100|0.71033027|  PASSED  
              sts_serial|   8|    100000|     100|0.96722395|  PASSED  
              sts_serial|   9|    100000|     100|0.91641391|  PASSED  
              sts_serial|   9|    100000|     100|0.49163744|  PASSED  
              sts_serial|  10|    100000|     100|0.15938257|  PASSED  
              sts_serial|  10|    100000|     100|0.06878810|  PASSED  
              sts_serial|  11|    100000|     100|0.49373039|  PASSED  
              sts_serial|  11|    100000|     100|0.98207713|  PASSED  
              sts_serial|  12|    100000|     100|0.92711192|  PASSED  
              sts_serial|  12|    100000|     100|0.20075197|  PASSED  
              sts_serial|  13|    100000|     100|0.39429256|  PASSED  
              sts_serial|  13|    100000|     100|0.46366977|  PASSED  
              sts_serial|  14|    100000|     100|0.21294681|  PASSED  
              sts_serial|  14|    100000|     100|0.21974485|  PASSED  
              sts_serial|  15|    100000|     100|0.41150808|  PASSED  
              sts_serial|  15|    100000|     100|0.92415191|  PASSED  
              sts_serial|  16|    100000|     100|0.88680634|  PASSED  
              sts_serial|  16|    100000|     100|0.23700928|  PASSED  
             rgb_bitdist|   1|    100000|     100|0.68249848|  PASSED  
             rgb_bitdist|   2|    100000|     100|0.92313781|  PASSED  
             rgb_bitdist|   3|    100000|     100|0.08362331|  PASSED  
             rgb_bitdist|   4|    100000|     100|0.99607074|   WEAK   
             rgb_bitdist|   5|    100000|     100|0.25499682|  PASSED  
             rgb_bitdist|   6|    100000|     100|0.13081079|  PASSED  
             rgb_bitdist|   7|    100000|     100|0.89699606|  PASSED  
             rgb_bitdist|   8|    100000|     100|0.44639384|  PASSED  
             rgb_bitdist|   9|    100000|     100|0.22478086|  PASSED  
             rgb_bitdist|  10|    100000|     100|0.22089060|  PASSED  
             rgb_bitdist|  11|    100000|     100|0.75068137|  PASSED  
             rgb_bitdist|  12|    100000|     100|0.13208896|  PASSED  
    rgb_minimum_distance|   2|     10000|    1000|0.45612663|  PASSED  
    rgb_minimum_distance|   3|     10000|    1000|0.28686203|  PASSED  
    rgb_minimum_distance|   4|     10000|    1000|0.46357420|  PASSED  
    rgb_minimum_distance|   5|     10000|    1000|0.11531414|  PASSED  
        rgb_permutations|   2|    100000|     100|0.16292815|  PASSED  
        rgb_permutations|   3|    100000|     100|0.43760130|  PASSED  
        rgb_permutations|   4|    100000|     100|0.00540516|  PASSED  
        rgb_permutations|   5|    100000|     100|0.79533306|  PASSED  
          rgb_lagged_sum|   0|   1000000|     100|0.46982294|  PASSED  
          rgb_lagged_sum|   1|   1000000|     100|0.53270557|  PASSED  
          rgb_lagged_sum|   2|   1000000|     100|0.80665055|  PASSED  
          rgb_lagged_sum|   3|   1000000|     100|0.82146109|  PASSED  
          rgb_lagged_sum|   4|   1000000|     100|0.66159611|  PASSED  
          rgb_lagged_sum|   5|   1000000|     100|0.98113744|  PASSED  
          rgb_lagged_sum|   6|   1000000|     100|0.43892064|  PASSED  
          rgb_lagged_sum|   7|   1000000|     100|0.52724566|  PASSED  
          rgb_lagged_sum|   8|   1000000|     100|0.16477750|  PASSED  
          rgb_lagged_sum|   9|   1000000|     100|0.57798969|  PASSED  
          rgb_lagged_sum|  10|   1000000|     100|0.11221597|  PASSED  
          rgb_lagged_sum|  11|   1000000|     100|0.80443802|  PASSED  
          rgb_lagged_sum|  12|   1000000|     100|0.82525649|  PASSED  
          rgb_lagged_sum|  13|   1000000|     100|0.42123060|  PASSED  
          rgb_lagged_sum|  14|   1000000|     100|0.11883167|  PASSED  
          rgb_lagged_sum|  15|   1000000|     100|0.60832606|  PASSED  
          rgb_lagged_sum|  16|   1000000|     100|0.12667169|  PASSED  
          rgb_lagged_sum|  17|   1000000|     100|0.22916439|  PASSED  
          rgb_lagged_sum|  18|   1000000|     100|0.41413413|  PASSED  
          rgb_lagged_sum|  19|   1000000|     100|0.87713055|  PASSED  
          rgb_lagged_sum|  20|   1000000|     100|0.02145493|  PASSED  
          rgb_lagged_sum|  21|   1000000|     100|0.33814446|  PASSED  
          rgb_lagged_sum|  22|   1000000|     100|0.46497792|  PASSED  
          rgb_lagged_sum|  23|   1000000|     100|0.17987287|  PASSED  
          rgb_lagged_sum|  24|   1000000|     100|0.73396659|  PASSED  
          rgb_lagged_sum|  25|   1000000|     100|0.59321186|  PASSED  
          rgb_lagged_sum|  26|   1000000|     100|0.42876158|  PASSED  
          rgb_lagged_sum|  27|   1000000|     100|0.84436496|  PASSED  
          rgb_lagged_sum|  28|   1000000|     100|0.64586015|  PASSED  
          rgb_lagged_sum|  29|   1000000|     100|0.79142364|  PASSED  
          rgb_lagged_sum|  30|   1000000|     100|0.61725433|  PASSED  
          rgb_lagged_sum|  31|   1000000|     100|0.44950121|  PASSED  
          rgb_lagged_sum|  32|   1000000|     100|0.06192355|  PASSED  
         rgb_kstest_test|   0|     10000|    1000|0.43600260|  PASSED  
         dab_bytedistrib|   0|  51200000|       1|1.00000000|  FAILED  
                 dab_dct| 256|     50000|       1|0.69523722|  PASSED  
    Preparing to run test 207.  ntuple = 0
            dab_filltree|  32|  15000000|       1|0.82014843|  PASSED  
            dab_filltree|  32|  15000000|       1|0.83320434|  PASSED  
    Preparing to run test 208.  ntuple = 0
           dab_filltree2|   0|   5000000|       1|0.71852504|  PASSED  
           dab_filltree2|   1|   5000000|       1|0.01693344|  PASSED  
    Preparing to run test 209.  ntuple = 0
            dab_monobit2|  12|  65000000|       1|0.49474714|  PASSED  
    #=============================================================================#
    # Summary: PASSED=106, WEAK=4, FAILED=4                                       #
    #          235,031.547 MB of random data created with 117.074 MB/sec          #
    #=============================================================================#
    #=============================================================================#
    # Runtime: 0:33:27                                                            #
    #=============================================================================#    
