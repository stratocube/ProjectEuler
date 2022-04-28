from math import log10

r5 = 5 ** 0.5
Phi = (1 + r5)/2
log_phi = log10(Phi)
log_r5 = log10(r5)

a = b = 1
n = 2
last9 = first9 = '0'

while True:
    # Only keep last 9 digits
    a, b = b, (a+b) % 1000000000
    n += 1

    last9_rep = "".join(sorted(str(b)[-9:]))
    if last9_rep == '123456789':
        # Only do this nasty calc if fast check for last 9 digits is correct
        # Based on Fn = (Phi^n - (-1/Phi)^n) / sqrt(5)
        # For large n Fn approx Phi^n / sqrt(5)
        # log10 Fn = n log10(Phi) - log10(sqrt(5))

        leading_calc = 10 ** ((n*log_phi - log_r5) % 1)
        leading_digits = str(leading_calc).replace('.', '')[:9]

        if "".join(sorted(leading_digits)) == '123456789':
            break

print(n)
