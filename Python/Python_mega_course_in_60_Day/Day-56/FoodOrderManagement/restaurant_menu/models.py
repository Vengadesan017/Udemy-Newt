from django.db import models


# Create your models here.

class Item(models.Model):
    meal = models.CharField(max_length=1000 ,unique=True)
    description  =models.CharField(max_length=2000)
    price = models.DecimalField(max_digits=10,decimal_places=2)
    date_created = models.DateTimeField(auto_now_add=True)
    date_updated = models.DateTimeField(auto_now=True)


    def __str__(self):
        return self.meal