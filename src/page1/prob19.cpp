#include <cstdio>
#include "bigint/BigIntegerLibrary.hh"

int main(void)
{
	try {
		BigInteger x(324);
	} catch (const char* err) {
		std::cout << err << std::endl;
	}
}
