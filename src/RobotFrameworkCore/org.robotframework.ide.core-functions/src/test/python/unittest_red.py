#!/usr/bin/env python
import sys
import xmlrunner

__unittest = True

from unittest.main import main
main(testRunner=xmlrunner.XMLTestRunner())