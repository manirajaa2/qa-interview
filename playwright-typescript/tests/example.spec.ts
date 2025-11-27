import { test, expect } from '@playwright/test';

test.describe('Basic Browser Launch Test', () => {
  test('should open example.com and verify URL', async ({ page }) => {
    await page.goto('https://www.example.com');
    
    await expect(page).toHaveURL('https://www.example.com/');
  });
});
